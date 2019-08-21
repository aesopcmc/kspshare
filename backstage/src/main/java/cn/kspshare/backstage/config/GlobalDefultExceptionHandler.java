package cn.kspshare.backstage.config;

import cn.kspshare.backstage.restful.ResultBean;
import cn.kspshare.backstage.restful.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
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
    @ResponseBody
    public ResultBean handleException(Exception ex) {
        log.error("捕获到全局异常", ex);
        return new ResultBean(ResultEnum.SERVER_EXCEPTION);
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
        return new ResultBean(ResultEnum.NO_PERMISSION);
    }

}
