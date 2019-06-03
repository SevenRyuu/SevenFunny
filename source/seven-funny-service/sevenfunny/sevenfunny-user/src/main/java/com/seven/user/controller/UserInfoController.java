package com.seven.user.controller;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.user.entity.UserInfo;
import com.seven.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

/**
 * @author ：SevenRyuu
 * date   ：2019/5/30 9:04 PM
 * email  ：sevenryuu77@gmail.com
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping(value = "/getUserInfo")
    //@RequestMapping(value = "/getUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
    public ResultResponse getUserInfo(@RequestBody UserInfo userInfo){
        return new ResultResponse(ResultCode.SUCCESS, userInfoService.getUserInfo(userInfo));
    }

    /**
     * 用户注册
     * @param userInfo 【手机号+密码+昵称】
     * @return
     */
    @PostMapping(value = "/register")
    public ResultResponse register(@RequestBody UserInfo userInfo){
        userInfoService.register(userInfo);
        return new ResultResponse(ResultCode.SUCCESS, null);
    }

    /**
     * 用户登录
     * @param userInfo 【手机号+密码】
     * @return
     */
    @PostMapping(value = "/login")
    public ResultResponse login(@RequestBody UserInfo userInfo){
        UserInfo returnUserInfo = userInfoService.findByMobileAndPassword(userInfo);
        if (returnUserInfo != null){
            return new ResultResponse(ResultCode.SUCCESS, null);
        }
        return new ResultResponse(ResultCode.USER_LOGIN_ERROR, null);
    }
}
