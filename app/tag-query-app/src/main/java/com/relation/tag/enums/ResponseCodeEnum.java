package com.relation.tag.enums;

import org.springframework.boot.extension.enums.ResponseCode;

/**
 * @author wilson
 */

public enum ResponseCodeEnum implements ResponseCode {
    //文件不能为空
    ERROR_FILE_NOT_NULL("ERROR_FILE_NOT_NULL", 2020),
    //文件不是csv文件
    ERROR_FILE_IS_NOT_CSV("ERROR_FILE_IS_NOT_CSV", 2021),
    //解析csv文件失败
    ERROR_PARSE_CSV_FAILED("ERROR_PARSE_CSV_FAILED", 2022),
    //没有地址被发现
    ERROR_NOT_FOUND_ADDRESS("ERROR_NOT_FOUND_ADDRESS", 2023),
    //解析执行计划失败
    ERROR_PARSE_EXPLAIN_FAILED("ERROR_PARSE_EXPLAIN_FAILED", 2024),
    //sql花费超过限制
    ERROR_SQL_COST_OVER_LIMIT("ERROR_SQL_COST_OVER_LIMIT", 2025),
    //创建api失败
    ERROR_CREATE_API_FAIELD("ERROR_CREATE_API_FAIELD", 2026),
    //未发现label
    ERROR_NOT_FOUND_LABEL("ERROR_NOT_FOUND_LABEL", 2027),
    //无权限删除
    ERROR_NOT_RIGHT_DELETE("ERROR_NOT_RIGHT_DELETE", 2028),
    //解析limit
    ERROR_NO_SQL_LIMIT("ERROR_NO_SQL_LIMIT", 2029),
    // 返回数据超过限制
    ERROR_SQL_LIMIT_OVER("ERROR_SQL_LIMIT_OVER", 2030),
    // SQL出错
    ERROR_SQL("ERROR_SQL", 2031),
    // 没有权限操作
    ERROR_NO_RIGHT_OPERATE("ERROR_NO_RIGHT_OPERATE", 2032),
    // 没有创建api key的权限
    ERROR_NO_RIGHT_CREATE_API_KEY("ERROR_NO_RIGHT_CREATE_API_KEY", 2033),
    // 没有发现标签
    ERROR_NOT_FOUNT_LABEL("ERROR_NOT_FOUNT_LABEL", 2034),
    // 标签已存在
    ERROR_LABEL_EXIST("ERROR_LABEL_EXIST", 2035),
    ERROR_ADDRESS_NOT_NULL("ERROR_ADDRESS_NOT_NULL", 2036),
    // 错误的地址格式
    ERROR_ADDRESS_FORMAT("ERROR_ADDRESS_FORMAT", 2037),
    // 部分地址上传成功
    SUCCESS_UPLOAD_PART_ADDRESS("SUCCESS_UPLOAD_PART_ADDRESS", 2),
    // 标签名称超过最大长度限制
    ERROR_LABEL_NAME_LENGTH_OVER_LIMIT("ERROR_LABEL_NAME_LENGTH_OVER_LIMIT", 2038),
    // 标签描述超过最大长度限制
    ERROR_LABEL_DESCRIPTION_LENGTH_OVER_LIMIT("ERROR_LABEL_DESCRIPTION_LENGTH_OVER_LIMIT", 2039),
    // 标签名称格式错误
    ERROR_LABEL_NAME_FORMAT("ERROR_LABEL_NAME_FORMAT", 2040),
    // 解析zip包失败
    ERROR_PARSE_ZIP_FAILED("ERROR_PARSE_ZIP_FAILED", 2041),
    // 仅仅接受地址
    ERROR_ONLY_ACCEPT_ADDRESS_COLUMN("ERROR_ONLY_ACCEPT_ADDRESS_COLUMN", 2042),
    //没有发现签名
    ERROR_NOT_FOUND_SIGN("ERROR_NOT_FOUND_SIGN", 2043),
    //签名解析失败
    ERROR_SIGN_PARSE_FAILED("ERROR_SIGN_PARSE_FAILED", 2044),
    //验证签名失败
    ERROR_SIGN_CHECK_FAILED("ERROR_SIGN_CHECK_FAILED", 2045),
    //签名过期
    ERROR_TIME_OVER_LIMIT("ERROR_TIME_OVER_LIMIT", 2046),
    // AR交易构造失败
    ERROR_ARWEAVE_TX_SIGN_FAILED("ERROR_ARWEAVE_TX_SIGN_FAILED", 2047),

    ERROR_API_KEY_NAME_ALREADY_EXIST("ERROR_API_KEY_NAME_ALREADY_EXIST", 2048),
    ERROR_API_KEY_IS_NOT_EXIST("ERROR_API_KEY_IS_NOT_EXIST", 2049),
    ERROR_API_KEY_COUNT_EXCEED("ERROR_API_KEY_COUNT_EXCEED", 2050),
    ERROR_REMOVE_FAILED("ERROR_REMOVE_FAILED", 2051),
    ;

    private int code;

    private String symbol;

    ResponseCodeEnum(String symbol, int code) {
        this.code = code;
        this.symbol = symbol;
    }

    @Override
    public String symbol() {
        return this.symbol;
    }

    @Override
    public int code() {
        return this.code;
    }
}
