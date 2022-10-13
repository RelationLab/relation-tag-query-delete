import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const name = "wired-tag-query";
const stack = pulumi.getStack();

const maintainer = new pulumi.Config().require("maintainer");
const dataSyncStackRef = new pulumi.StackReference(
  `${maintainer}/relation-data-sync/dev`
);
const ugcInfraStackRef = new pulumi.StackReference(
  `${maintainer}/wired-ugc-infra/${stack}`
);

const tags = {
  Name: `${name}-${stack}`,
  Project: "Wired.network",
  Stack: `Pulumi-${stack}`,
};

let ecr;

if (stack == "dev") {
  ecr = new aws.ecr.Repository(name, {
    name,
    tags,
  });

  new aws.ecr.RepositoryPolicy(
    tags.Name,
    {
      repository: ecr.id,
      policy: JSON.stringify({
        Version: "2012-10-17",
        Statement: [
          {
            Sid: "new policy",
            Effect: "Allow",
            Principal: "*",
            Action: [
              "ecr:GetDownloadUrlForLayer",
              "ecr:BatchGetImage",
              "ecr:BatchCheckLayerAvailability",
              "ecr:PutImage",
              "ecr:InitiateLayerUpload",
              "ecr:UploadLayerPart",
              "ecr:CompleteLayerUpload",
              "ecr:DescribeRepositories",
              "ecr:GetRepositoryPolicy",
              "ecr:ListImages",
              "ecr:DeleteRepository",
              "ecr:BatchDeleteImage",
              "ecr:SetRepositoryPolicy",
              "ecr:DeleteRepositoryPolicy",
            ],
          },
        ],
      }),
    },
    { deleteBeforeReplace: true }
  );

  new aws.ecr.LifecyclePolicy(
    tags.Name,
    {
      repository: ecr.id,
      policy: JSON.stringify({
        rules: [
          {
            rulePriority: 1,
            description: "Expire images older than 14 days",
            selection: {
              tagStatus: "untagged",
              countType: "sinceImagePushed",
              countUnit: "days",
              countNumber: 14,
            },
            action: {
              type: "expire",
            },
          },
        ],
      }),
    },
    { deleteBeforeReplace: true }
  );
} else {
  ecr = aws.ecr.Repository.get(name, name);
}

export const ecrRepositoryName = ecr.name;
export const ecrRepositoryUrl = ecr.repositoryUrl;

export const dataSyncSecretId = dataSyncStackRef.getOutput("awsSecretId");
export const dataSyncDatabaseName =
  dataSyncStackRef.getOutput("rdsDatabaseName");
export const dataSyncDatabaseReadUserName =
  dataSyncStackRef.getOutput("rdsReadUserNAme");
export const dataSyncDatabaseAddress =
  dataSyncStackRef.getOutput("rdsDatabaseAddress");
export const dataSyncDatabaseReaderAddress = dataSyncStackRef.getOutput(
  "rdsDatabaseReaderAddress"
);
export const redisClusterEndpoint = ugcInfraStackRef.getOutput(
  "redisClusterEndpoint"
);