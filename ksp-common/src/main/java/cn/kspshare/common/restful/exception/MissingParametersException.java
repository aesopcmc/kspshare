// package cn.kspshare.common.restful.exception;
// import cn.kspshare.common.restful.ResultCode;
//
// /**
//  * 参数不全异常
//  * @author Aesop(chao_c_c @ 163.com)
//  * @date 2020/3/25 15:17
//  */
// public class MissingParametersException extends BaseException {
//     private static final long serialVersionUID = -750185439522212123L;
//     private ResultCode code=ResultCode.MISSING_PARAMETERS;
//     private String msg=ResultCode.MISSING_PARAMETERS.getMsg();
//     private Object data;
//
//     public MissingParametersException() {
//         super(ResultCode.MISSING_PARAMETERS.getMsg());
//     }
//
//     /**
//      * 创建异常，传入消息
//      * @param message
//      */
//     public MissingParametersException(String message) {
//         super(message);
//         this.msg = message;
//     }
//
//     /**
//      * 创建异常，传入异常对象
//      * @param cause
//      */
//     public MissingParametersException(Throwable cause) {
//         super(cause);
//     }
//
//     /**
//      * 创建异常，传入消息和异常对象
//      * @param cause
//      */
//     public MissingParametersException(String message, Throwable cause) {
//         super(message, cause);
//         this.msg = message;
//     }
//
//     /**
//      * 设置返回的数据
//      * @param data
//      * @return
//      */
//     public MissingParametersException setData(Object data) {
//         this.data = data;
//         return this;
//     }
//
//     public Object getData() {
//         return data;
//     }
//
//     public ResultCode getCode() {
//         return code;
//     }
//
//     public String getMsg() {
//         return msg;
//     }
// }
