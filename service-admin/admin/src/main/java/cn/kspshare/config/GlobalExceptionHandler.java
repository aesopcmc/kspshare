package cn.kspshare.config;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.common.restful.ResultCode;
import cn.kspshare.common.restful.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 捕获参数异常，一般用于校验body参数
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
        return ResultBean.INFO(ResultCode.INVALID_REQUEST_PARAMETER, ResultCode.INVALID_REQUEST_PARAMETER.getMsg()+":"+fieldName+"["+msg+"]");
    }

    /**
     * 捕获全局异常 Exception
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handleException(Exception ex) {
        log.error("捕获到全局异常", ex);
        return ResultBean.FAIL(ex.getMessage());
    }

    /**
     * 捕获自定义异常 BaseException
     * @param ex
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResultBean handleException(BaseException ex) {
        log.error("捕获到自定义异常", ex);
        return ResultBean.INFO(ex.getCode(), ex.getMsg()).setData(ex.getData());
    }
}
