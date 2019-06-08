package com.seven.user.controller;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.common.util.JwtUtil;
import com.seven.user.entity.UserInfo;
import com.seven.user.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private HttpServletRequest request;

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value = "/getUserInfo", method={RequestMethod.GET,RequestMethod.POST})
    public ResultResponse getUserInfo(){

        //获取jwt头信息
        String token = (String) request.getAttribute("token");
        UserInfo userInfo = userInfoService.findById(jwtUtil.getUserIdByToken(token));
        if(userInfo == null){
            return new ResultResponse(ResultCode.USER_NOT_LOGGED_IN);
        }

        return new ResultResponse(ResultCode.SUCCESS, userInfo);
    }

    /**
     * 用户注册
     * @param userInfo 【手机号+密码+昵称】
     * @return
     */
    @PostMapping(value = "/register")
    public ResultResponse register(@RequestBody UserInfo userInfo){
        //手机号及密码不能为空
        if(StringUtils.isBlank(userInfo.getMobile()) || StringUtils.isBlank(userInfo.getPassword())){
            return new ResultResponse(ResultCode.PARAM_IS_BLANK);
        }
        //验证手机号或昵称是否已经存在
        if(userInfoService.checkMobileCnt(userInfo.getMobile()) > 0 || userInfoService.checkNicknameCnt(userInfo.getNickname()) > 0){
            return  new ResultResponse(ResultCode.USER_HAS_EXISTED);
        }
        userInfoService.register(userInfo);
        return new ResultResponse(ResultCode.SUCCESS);
    }

    /**
     * 用户登录
     * @param userInfo 【手机号+密码】
     * @return
     */
    @PostMapping(value = "/login")
    public ResultResponse login(@RequestBody UserInfo userInfo){
        //手机号及密码不能为空
        if(StringUtils.isBlank(userInfo.getMobile()) || StringUtils.isBlank(userInfo.getPassword())){
            return new ResultResponse(ResultCode.PARAM_IS_BLANK);
        }

        UserInfo returnUserInfo = userInfoService.checkMobilePassword(userInfo.getMobile(),userInfo.getPassword());

        if (returnUserInfo != null){
            //生成token
            String token = jwtUtil.createToken(returnUserInfo.getId(),returnUserInfo.getMobile(),returnUserInfo.getNickname());
            Map map = new HashMap();
            map.put("token", token);
            map.put("userInfo", returnUserInfo);

            return new ResultResponse(ResultCode.SUCCESS, map);
        }
        return new ResultResponse(ResultCode.USER_NOT_EXIST);
    }

    /**
     * 更新用户基本信息
     * @param userInfo 【头像+简介】
     * @return
     */
    @PostMapping(value = "updateUserInfo")
    public ResultResponse updateUserInfo(@RequestBody UserInfo userInfo){
        userInfoService.updateUserInfo(userInfo);
        return new ResultResponse(ResultCode.SUCCESS);
    }

    /**
     * 修改用户密码
     * @param requestMap 【id+原密码+新密码】
     * @return
     */
    @PostMapping(value = "changePassword")
    public ResultResponse changePassword(@RequestBody Map<String,String> requestMap){
        userInfoService.changePassword(requestMap.get("id"),requestMap.get("oldPassword"), requestMap.get("newPassword"));
        return new ResultResponse(ResultCode.SUCCESS);
    }

    @PostMapping(value = "/getById")
    public ResultResponse getById(@RequestBody UserInfo userInfo){
        return new ResultResponse(ResultCode.SUCCESS, userInfoService.findById(userInfo.getId()));
    }

    @PostMapping(value = "/delById")
    public ResultResponse delById(@RequestBody UserInfo userInfo){
        userInfoService.delById(userInfo.getId());
        return new ResultResponse(ResultCode.SUCCESS);
    }

    @PostMapping(value = "/getByMobile")
    public ResultResponse getByMobile(@RequestBody UserInfo userInfo){
        return new ResultResponse(ResultCode.SUCCESS, userInfoService.findByMobileCache(userInfo.getMobile()));
    }

    @PostMapping(value = "/delByMobile")
    public ResultResponse delByMobile(@RequestBody UserInfo userInfo){
        userInfoService.delByMobileCache(userInfo.getMobile());
        return new ResultResponse(ResultCode.SUCCESS);
    }

    @GetMapping(value = "/test")
    public ResultResponse test(String mobile, String password){
        System.out.println("mobile >---------------->"+mobile);
        System.out.println("password >---------------->"+password);
        UserInfo returnUserInfo = userInfoService.checkMobilePassword(mobile,password);
        if (returnUserInfo != null){
            return new ResultResponse(ResultCode.SUCCESS);
        }
        return new ResultResponse(ResultCode.USER_LOGIN_ERROR);
    }
}
