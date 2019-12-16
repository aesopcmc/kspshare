package cn.kspshare.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalDefultExceptionHandler {
    /**
     * 处理参数异常，一般用于校验body参数
     *
     * @param e
     * @return
     */
    //@ExceptionHandler(MethodArgumentNotValidException.class)
    //public ErrorMessage handleValidationBodyException(MethodArgumentNotValidException e) {
    //    for (ObjectError s : e.getBindingResult().getAllErrors()) {
    //        return new ErrorMessage("Invalid_Request_Parameter", s.getObjectName() + ": " + s.getDefaultMessage());
    //    }
    //    return new ErrorMessage("Invalid_Request_Parameter", "未知参数错误");
    //}

    /**
     * 统一异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        log.error("捕获到全局异常", ex);
        return "500";
    }

}
