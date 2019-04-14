package cn.kspshare.backstage.restful;

public enum ResultEnum {
    FAIL(-1, "失败"),
    SUCCESS(0, "成功"),
    MISSING_PARAMETERS(1, "参数不全"),
    SERVER_EXCEPTION(2, "服务器异常");

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
