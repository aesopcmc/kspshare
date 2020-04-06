package cn.kspshare.config;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.common.restful.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalDefultExceptionHandler {
    /**
     * 处理参数异常，一般用于校验body参数
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultBean handleValidationBodyException(MethodArgumentNotValidException e) {
        String fieldName = e.getBindingResult().getFieldError().getField();
        String msg = "";
        for (ObjectError s : e.getBindingResult().getAllErrors()) {
            msg += s.getDefaultMessage() + " ";
        }
        return ResultBean.FAIL(ResultEnum.INVALID_REQUEST_PARAMETER, ResultEnum.INVALID_REQUEST_PARAMETER.getMsg()+":"+fieldName+"["+msg+"]");
    }

    /**
     * 统一异常处理
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handleException(Exception ex) {
        log.error("捕获到全局异常", ex);
        return ResultBean.SERVER_EXCEPTION();
    }

    /**
     * 没有访问权限
     * @param ex
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public ResultBean handleException(AccessDeniedException ex) {
        log.warn("没有访问权限");
        return ResultBean.NO_PERMISSION();
    }


    /**
     * ksp自定义异常
     * @param ex
     * @return
     */
    @ExceptionHandler(KspException.class)
    @ResponseBody
    public ResultBean handleException(KspException ex) {
        log.error("捕获到KSP自定义异常", ex);
        return ResultBean.FAIL(ex.getMessage());
    }

}
