package cn.kspshare.backstage.restful;

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

    /**
     * 返回成功的构造函数
     */
    public ResultBean(T data) {
        this.data = data;
    }

    ///**
    // * 返回错误（获取数据错误）的构造函数
    // */
    //public ResultBean(BaseRuntimeException e) {
    //    this.msg = e.getMessage();
    //    this.code = e.getCode();
    //}

    /**
     * 自定义代码和消息
     */
    public ResultBean(ResultEnum resultEnum, String msg) {
        this.code = resultEnum.getCode();
        this.msg = msg;
    }

    /**
     * 自定义代码
     */
    public ResultBean(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
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
