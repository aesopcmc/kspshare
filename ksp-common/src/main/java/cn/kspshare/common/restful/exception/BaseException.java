package cn.kspshare.common.restful.exception;

import cn.kspshare.common.restful.ResultCode;

/**
 * 自定义异常抽象
 * 可在GlobalExceptionHandler中 拦截该异常进行统一处理
 *
 * @author Aesop
 */
public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = -2386304947222127939L;

    BaseException(String message) {
        super(message);
    }

    BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    BaseException(Throwable cause) {
        super(cause);
    }

    /**
     * 设置返回的数据
     * @param data
     * @return
     */
    public abstract BaseException setData(Object data);

    public abstract Object getData();

    public abstract ResultCode getCode();

    public abstract String getMsg();

}
