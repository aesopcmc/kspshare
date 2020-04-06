package cn.kspshare.common.restful;

import java.io.Serializable;

/**
 * Created on 2017/12/13.
 * restful 风格 API 返回结果固定结构
 *
 * @author DuanJiaNing
 */

public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = -4101051436094606437L;

    private int code = ResultEnum.SUCCESS.getCode();

    private String msg = ResultEnum.SUCCESS.getMsg();

    private T data;

    private ResultBean(T data) {
        this.data = data;
    }

    private ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功
     * @return
     */
    public static ResultBean SUCCESS() {
        return new ResultBean(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg());
    }

    /**
     * 成功，返回数据
     * @param data
     * @return
     */
    public static ResultBean SUCCESS(Object data) {
        return new ResultBean<>(data);
    }

    /**
     * 失败
     * @return
     */
    public static ResultBean FAIL() {
        return new ResultBean(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg());
    }

    /**
     * 失败，返回自定义消息
     * @param msg
     * @return
     */
    public static ResultBean FAIL(String msg) {
        return new ResultBean(ResultEnum.FAIL.getCode(), msg);
    }

    public static ResultBean FAIL(ResultEnum codeEnum) {
        return new ResultBean(codeEnum.getCode(), codeEnum.getMsg());
    }

    public static ResultBean FAIL(ResultEnum codeEnum, String msg) {
        return new ResultBean(codeEnum.getCode(), msg);
    }

    /**
     * 参数不全
     * @return
     */
    public static ResultBean MISSING_PARAMETERS() {
        return new ResultBean(ResultEnum.MISSING_PARAMETERS.getCode(), ResultEnum.MISSING_PARAMETERS.getMsg());
    }

    /**
     * 服务器异常
     * @return
     */
    public static ResultBean SERVER_EXCEPTION() {
        return new ResultBean(ResultEnum.SERVER_EXCEPTION.getCode(), ResultEnum.SERVER_EXCEPTION.getMsg());
    }

    /**
     * 权限不足
     * @return
     */
    public static ResultBean NO_PERMISSION() {
        return new ResultBean(ResultEnum.NO_PERMISSION.getCode(), ResultEnum.NO_PERMISSION.getMsg());
    }

    /**
     * 无效的请求参数
     * @return
     */
    public static ResultBean INVALID_REQUEST_PARAMETER() {
        return new ResultBean(ResultEnum.INVALID_REQUEST_PARAMETER.getCode(), ResultEnum.INVALID_REQUEST_PARAMETER.getMsg());
    }

    /**
     * 主键不能为空
     * @return
     */
    public static ResultBean PRIMARY_KEY_ONT_NULL() {
        return new ResultBean(ResultEnum.PRIMARY_KEY_ONT_NULL.getCode(), ResultEnum.PRIMARY_KEY_ONT_NULL.getMsg());
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
