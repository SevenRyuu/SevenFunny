package com.seven.user.controller;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.user.entity.UserInfo;
import com.seven.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        ResultResponse resultResponse = new ResultResponse(ResultCode.SUCCESS, userInfoService.getUserInfo(userInfo));
        return resultResponse;
    }


}
