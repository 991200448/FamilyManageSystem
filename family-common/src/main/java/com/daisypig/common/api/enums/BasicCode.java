package com.daisypig.common.api.enums;


import java.util.Arrays;
import java.util.Optional;

public enum BasicCode implements ResponseCodeI {

    SUCCESS("100000", "操作成功"),
    ERROR("100001", "失败，原因: %s"),
    UNKNOWN_ERROR("100002", "未知的系统错误"),
    PARAM_ERROR("100003", "参数校验错误"),
    PARAM_MISSING("100004", "缺少参数: %s"),
    INVALID_PARAM("100005", "非法参数: %s"),
    PARAM_LENGTH_LIMIT("100006", "参数长度超出限制"),
    PARAM_NOT_BLANK("100007", "非空参数不能为空"),
    COLA_BIZ_ERROR("100008" , "通用的业务逻辑错误"),
    ASSERT_ERROR("100009" , "断言失败"),

    INVALID_REQUEST("100010", "非法请求"),
    REQUEST_TIMEOUT("100011", "请求超时"),
    CONNECT_FAILED("100012", "网络连接出错"),
    COLA_ERROR("100013" , "COLA框架错误"),
    NPE("100014", "空指针错误"),
    RPC_ERROR_404("100015", "远程服务调用404错误"),
    RPC_TIMEOUT("100016", "远程服务调用超时"),
    RPC_UNKNOWN_ERROR("100017", "远程服务调用未知错误"),

    FILE_SIZE_LIMIT("100200", "文件大小不合法"),
    FILE_TYPE_LIMIT("100201", "文件类型不合法"),
    FILE_WRITE_ERROR("100202", "文件写入异常"),
    FILE_UPLOAD_ERROR("100203", "上传文件发生未知异常"),
    FILE_CREATE_SUMMARY_FAILED("100204", "创建文件摘要失败"),
    FILE_READ_ERROR("100205", "读取文件失败"),
    FILE_NOT_EXIST("100206", "文件不存在"),
    FILE_REPEAT("100207", "文件重复"),
    DATA_SYNC_FAILED("100208", "数据同步失败"),
    INVALID_DATA("100209", "数据失效"),
    DATA_IMMUTABLE("100210", "该数据不允许修改"),
    DATA_UNABLE_DELETE("100211", "该数据不允许删除"),
    DATA_NOT_EXIST("100212", "该数据不存在"),
    INVALID_VERIFICATION_CODE("100213", "验证码已失效"),
    VERIFICATION_CODE_ERROR("100214", "验证码错误"),
    DATE_FORMAT_ERROR("100215", "日期格式错误"),

    DB_SAVE_FAILED("100500", "数据库记录创建失败"),
    DB_UPDATE_FAILED("100501", "数据库记录更新失败"),
    DB_NOT_MATCH_DELETE("100502", "数据库没有匹配的记录可删除"),
    DB_QUERY_NO_RESULT("100503", "数据库没有找到匹配的记录"),
    DB_QUERY_ERROR("100504", "数据库记录查询错误"),
    DB_MASTER_SLAVE_SYNC_ERROR("100505", "数据库主从不同步"),
    DB_UNIQUE_CHECK_ERROR("100506", "违反数据库唯一索引"),

    MQ_CONFIG_ERROR("100550", "MQ配置错误: %s"),

    TRAFFIC_INTERFACE("100600", "接口限流保护"),
    TRAFFIC_HOT_SPOT("100601", "热点参数限流保护"),
    TRAFFIC_SYSTEM_ADAPTIVE("100602", "系统自适应限流保护"),
    TRAFFIC_ORIGIN("100603", "请求源限流保护"),
    TRAFFIC_SERVICE_DOWNGRADE("100604", "服务降级"),
    NO_RECORD("MR0001", "No record in the system database matches the searching criteria");

    private String code;
    private String desc;

    private BasicCode(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    public static BasicCode getEnum(String code) {

        if(code == null || code == "") {
            return null;
        }
        Optional<BasicCode> opt = Arrays.stream(BasicCode.values()).filter(item -> item.code.equals(code)).findFirst();
        return opt.orElse(null);
    }
}
