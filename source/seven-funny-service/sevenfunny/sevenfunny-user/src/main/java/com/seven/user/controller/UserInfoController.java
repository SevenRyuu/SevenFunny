package com.seven.user.controller;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.common.util.JwtUtil;
import com.seven.user.entity.UserInfo;
import com.seven.user.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Value("${jwt.config.tokenHead}")
    private String tokenHead;

    @Value("${jwt.config.header}")
    private String header;

    /**
     * 获取用户信息
     * @return
     */
    @PostMapping(value = "/getUserInfo")
    public ResultResponse getUserInfo(){

        //获取jwt头信息
        String authHeader = request.getHeader(header);

        if(authHeader == null){
            return new ResultResponse(ResultCode.USER_NOT_LOGGED_IN);
        }
        //提取token
        String token = authHeader.substring(tokenHead.length());
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
        //用户已存在
        if (userInfoService.findByMobile(userInfo.getMobile()) != null){
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
        UserInfo returnUserInfo = userInfoService.findByMobileAndPassword(userInfo.getMobile(),userInfo.getPassword());
        if (returnUserInfo != null){
            //生成token
            String token = jwtUtil.createToken(returnUserInfo.getId(),returnUserInfo.getMobile(),returnUserInfo.getNickname());
            Map map = new HashMap();
            map.put("token", token);
            map.put("nickname", returnUserInfo.getNickname());

            return new ResultResponse(ResultCode.SUCCESS, map);
        }
        return new ResultResponse(ResultCode.USER_LOGIN_ERROR);
    }

    @PostMapping(value = "/test")
    public ResultResponse test(String mobile, String password){
        System.out.println("mobile >---------------->"+mobile);
        System.out.println("password >---------------->"+password);
        UserInfo returnUserInfo = userInfoService.findByMobileAndPassword(mobile,password);
        if (returnUserInfo != null){
            return new ResultResponse(ResultCode.SUCCESS);
        }
        return new ResultResponse(ResultCode.USER_LOGIN_ERROR);
    }
}
