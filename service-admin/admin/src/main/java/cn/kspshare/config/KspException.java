package cn.kspshare.config;

/**
 * KSP自定义异常
 */
@Deprecated
public class KspException extends RuntimeException {
    public KspException() {
        super();
    }

    public KspException(String message) {
        super(message);
    }

    public KspException(String message, Throwable cause) {
        super(message, cause);
    }

    public KspException(Throwable cause) {
        super(cause);
    }
}
