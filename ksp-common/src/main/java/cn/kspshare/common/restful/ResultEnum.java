package cn.kspshare.common.restful;

/**
 * 结果状态枚举
 */
public enum ResultEnum {
    FAIL(-1, "操作失败"),
    SUCCESS(0, "成功"),
    MISSING_PARAMETERS(1, "参数不全"),
    SERVER_EXCEPTION(2, "服务器异常"),
    NO_PERMISSION(3, "权限不足"),
    INVALID_REQUEST_PARAMETER(4, "无效的请求参数"),
    PRIMARY_KEY_ONT_NULL(5, "主键不能为空");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
