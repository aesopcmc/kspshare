package cn.kspshare.common.restful.exception;

import cn.kspshare.common.restful.ResultCode;

/**
 * 异常工厂
 * @author Aesop
 */
public class BaseExceptionFactory {

    public static BaseException get(ResultCode code, String msg, Throwable cause) {
        return new BaseException(msg, cause) {
            private static final long serialVersionUID = 2810589188924981359L;
            private Object data;

            @Override
            public BaseException setData(Object data) {
                this.data = data;
                return this;
            }

            @Override
            public Object getData() {
                return this.data;
            }

            @Override
            public ResultCode getCode() {
                return code;
            }

            @Override
            public String getMsg() {
                return msg;
            }
        };
    }

    public static BaseException get(ResultCode code, String msg) {
        return new BaseException(msg) {
            private static final long serialVersionUID = 2810589188924981359L;
            private Object data;

            @Override
            public BaseException setData(Object data) {
                this.data = data;
                return this;
            }

            @Override
            public Object getData() {
                return this.data;
            }

            @Override
            public ResultCode getCode() {
                return code;
            }

            @Override
            public String getMsg() {
                return msg;
            }
        };
    }

    public static BaseException get(ResultCode code) {
        return new BaseException(code.getMsg()) {
            private static final long serialVersionUID = 2810589188924981359L;
            private Object data;

            @Override
            public BaseException setData(Object data) {
                this.data = data;
                return this;
            }

            @Override
            public Object getData() {
                return this.data;
            }

            @Override
            public ResultCode getCode() {
                return code;
            }

            @Override
            public String getMsg() {
                return code.getMsg();
            }
        };
    }

    public static BaseException get(ResultCode code, Throwable cause) {
        return new BaseException(cause) {
            private static final long serialVersionUID = 2810589188924981359L;
            private Object data;

            @Override
            public BaseException setData(Object data) {
                this.data = data;
                return this;
            }

            @Override
            public Object getData() {
                return this.data;
            }

            @Override
            public ResultCode getCode() {
                return code;
            }

            @Override
            public String getMsg() {
                return code.getMsg();
            }
        };
    }

    public static BaseException get() {
        return BaseExceptionFactory.get(ResultCode.FAIL);
    }

    public static BaseException get(String msg) {
        return BaseExceptionFactory.get(ResultCode.FAIL, msg);
    }
}
