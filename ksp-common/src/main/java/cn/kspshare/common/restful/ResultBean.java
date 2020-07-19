package cn.kspshare.common.restful;

import java.io.Serializable;

/**
 * Created on 2017/12/13.
 * restful 风格 API 返回结果固定结构
 *
 * @author Aesop
 */
public class ResultBean implements Serializable {

    private static final long serialVersionUID = -4101051436094606437L;

    private int code;

    private String msg;

    private Object data;

    private ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功
     * @return
     */
    public static ResultBean SUCCESS() {
        return new ResultBean(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());
    }

    /**
     * 成功，自定义消息
     * @param msg
     * @return
     */
    public static ResultBean SUCCESS(String msg) {
        return new ResultBean(ResultCode.SUCCESS.getCode(), msg);
    }

    /**
     * 失败
     * @return
     */
    public static ResultBean FAIL() {
        return new ResultBean(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMsg());
    }

    /**
     * 失败，自定义消息
     * @return
     */
    public static ResultBean FAIL(String msg) {
        return new ResultBean(ResultCode.FAIL.getCode(), msg);
    }

    /**
     * 自定义返回参数
     * @return
     */
    public static ResultBean INFO(ResultCode code) {
        return new ResultBean(code.getCode(), code.getMsg());
    }

    /**
     * 自定义返回参数
     * @return
     */
    public static ResultBean INFO(ResultCode code, String msg) {
        return new ResultBean(code.getCode(), msg);
    }

    /**
     * 获取数据
     * @return
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置数据
     * @param data
     * @return
     */
    public ResultBean setData(Object data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
