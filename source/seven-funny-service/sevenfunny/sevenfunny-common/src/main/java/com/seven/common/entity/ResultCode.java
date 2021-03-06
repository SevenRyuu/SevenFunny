package com.seven.common.entity;

/**
 * @author ：SevenRyuu
 * date   ：2019/5/30 8:30 PM
 * email  ：sevenryuu77@gmail.com
 */
public enum ResultCode {

    /*成功状态码*/
    SUCCESS(1,"成功"),
    /*异常状态码*/
    ERROR(2,"异常"),
    /*1000~1999  区间表示参数错误*/
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),
    /*2000~2999  区间表示用户错误*/
    USER_NOT_LOGGED_IN(2001, "用户未登录，访问的路径需要验证，请登录"),
    USER_LOGIN_ERROR(2002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003, "账号已被禁用"),
    USER_NOT_EXIST(2004, "用户不存在"),
    USER_HAS_EXISTED(2005, "用户已存在"),
    USER_PASSWORD_ERROR(2006, "密码错误"),
    USER_VERIFICATION_CODE_INVALID(2007, "验证码无效、请输入正确的验证码"),
    USER_ACCOUNT_PASSWORD_IS_BLANK(2008, "用户名或密码为空"),
    /*3000~3999 区间表示话题错误*/
    TOPIC_NOT_EXIST(3000, "不存在");
    /*3000~3999  区间表示接口异常*/

    ;

    private Integer code;
    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }
}
