package cn.kspshare.backstage.config;

/**
 * KSP自定义异常
 */
public class KspException extends Exception {
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
