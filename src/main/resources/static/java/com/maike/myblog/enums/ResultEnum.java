package com.maike.myblog.enums;
/**
 * @projectname ValidCode
 * @author GEEKCJJ
 * @date 2019年7月31日 下午7:10:22
 * @description:
 *
 */
public enum ResultEnum {
	//这里是可以自己定义的，方便与前端交互即可
	/**
	 * 未知错误
	 */
    UNKNOWN_ERROR(-1,"未知错误"),
    /**
     * 权限不足
     */
    NO_PERMISSION(20001,"权限不足"),
    /**
     * 服务器异常
     */
    SERVER_ERROR(20002,"服务器异常"),
    /**
     * 认证失败
     */
    AUTH_ERROR(11111,"认证失败"),
    /**
     * 参数错误
     */
    PARAMS_ERROR(22222,"参数错误"),
    /**
     * Json解析错误
     */
    JSON_PARSE_ERROR(1010,"Json解析错误"),
    /**
     * 非法字符串
     */
    ILLEAGAL_STRING(1001,"非法字符串"),
    /**
     * 成功
     */
    SUCCESS(1000,"成功"),
    /**
     * 用户不存在
     */
    USER_NOT_EXIST(0321,"用户不存在"),
    /**
     * 邮箱不存在
     */
    EMAIL_NOT_EXIST(0322,"邮箱不存在"),
    /**
     * 手机号不存在
     */
    PHONE_NOT_EXIST(0323,"手机号不存在"),
    /**
     * 用户已存在
     */
    USER_IS_EXISTS(0123,"用户已存在"),
    /**
     * 数据为空
     */
    DATA_IS_NULL(0000,"数据为空");
    private Integer code;
    private String msg;
 
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
 
    public Integer getCode() {
        return code;
    }
 
    public String getMsg() {
        return msg;
    }
}
