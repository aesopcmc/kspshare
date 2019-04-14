package cn.kspshare.backstage.config;

import cn.kspshare.backstage.restful.ResultBean;
import cn.kspshare.backstage.restful.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefultExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalDefultExceptionHandler.class);
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
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultBean handleException(Exception ex) {
        logger.error("捕获到全局异常",ex);
        return new ResultBean(ResultEnum.SERVER_EXCEPTION);
    }

}
