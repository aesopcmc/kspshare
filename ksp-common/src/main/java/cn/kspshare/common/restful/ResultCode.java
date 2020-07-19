package cn.kspshare.common.restful;

/**
 * 结果状态枚举
 * @author Aesop
 */
public enum ResultCode {
    FAIL(-1, "操作失败"),
    SUCCESS(0, "操作成功"),

    MISSING_PARAMETERS(100, "参数不全"),
    SERVER_EXCEPTION(101, "服务器异常"),
    NO_PERMISSION(102, "权限不足"),
    INVALID_REQUEST_PARAMETER(103, "无效的请求参数"),
    PRIMARY_KEY_ONT_NULL(104, "主键不能为空");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
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
