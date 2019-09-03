package com.seven.user.interceptor;

import com.seven.common.exception.SevenFunnyException;
import com.seven.common.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：SevenRyuu
 * date   ：2019/6/8 8:51 AM
 * email  ：sevenryuu77@gmail.com
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Value("${jwt.config.tokenHead}")
    private String tokenHead;

    @Value("${jwt.config.header}")
    private String header;

    @Autowired
    JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("经过了拦截器");

        //无论如何都放行、具体能不能操作还是在具体的操作中去判断
        //拦截器只是负责把请求头中包含token的令牌进行一个解析验证

        //获取jwt头信息
        String authHeader = request.getHeader(header);

        //请求头token不能为空、否则提示进行登录后再操作
        if(StringUtils.isBlank(authHeader)){
            throw new SevenFunnyException("USER_NOT_LOGGED_IN");
        }

        //如果头信息不等于空
        //提取token
        String token = authHeader.substring(tokenHead.length());
        if(null == token){
            throw new SevenFunnyException("USER_NOT_LOGGED_IN");
        }

        //request.setAttribute("token", token);
        String token_user_id = jwtUtil.getUserIdByToken(token);
        //String token_mobile = jwtUtil.getMobileByToken(token);
        //String token_nickname = jwtUtil.getNicknameByToken(token);
        request.setAttribute("token_user_id", token_user_id);
        //request.setAttribute("token_mobile", token_mobile);
        //request.setAttribute("token_nickname", token_nickname);

        return true;
    }

}
