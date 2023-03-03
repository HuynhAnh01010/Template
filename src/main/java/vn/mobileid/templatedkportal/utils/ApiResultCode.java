/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.mobileid.templatedkportal.utils;

/**
 *
 * @author Mobile ID 21
 */
public enum ApiResultCode {
    //成功
    SUCCESS(0, "SUCCESSFULLY"),
    //失败
    FAILURE(400, "FAILURE"),
    // 未登录
    UN_LOGIN(401, "Not logged in"),
    //未认证（签名错误、token错误）
    UNAUTHORIZED(403, "Not authenticated or the token is invalid"),
    //未通过认证
    USER_UNAUTHORIZED(402, "Username or password is incorrect"),
    //接口不存在
    NOT_FOUND(404, "Interface does not exist"),
    //服务器内部错误
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private int code;
    private String desc;

    ApiResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
