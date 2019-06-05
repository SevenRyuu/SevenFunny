package com.seven.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties("jwt.config")
public class JwtUtil {

    private static final String CLAIM_KEY_USER_ID = "userId";
    private static final String CLAIM_KEY_MOBILE = "mobile";
    private static final String CLAIM_KEY_NICKNAME = "nickname";
    private static final String CLAIM_KEY_CREATED = "created";

    private String key;

    private long ttl;//一个小时

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    /**
     * 生成token
     * @param userId
     * @param mobile
     * @param nickname
     * @return
     */
    public String createToken(String userId,String mobile, String nickname){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USER_ID,userId);
        claims.put(CLAIM_KEY_MOBILE,mobile);
        claims.put(CLAIM_KEY_NICKNAME,nickname);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return createToken(claims);
    }

    /**
     * 通过token获取userId
     * @param token
     * @return
     */
    public String getUserIdByToken(String token){
        String userId;
        try {
            final Claims claims = parseJWT(token);
            userId = claims.get(CLAIM_KEY_USER_ID).toString();
        }catch (Exception e){
            userId = null;
        }
        return userId;
    }

    /**
     * 通过token获取mobile
     * @param token
     * @return
     */
    public String getMobileByToken(String token){
        String mobile;
        try {
            final Claims claims = parseJWT(token);
            mobile = claims.get(CLAIM_KEY_MOBILE).toString();
        }catch (Exception e){
            mobile = null;
        }
        return mobile;
    }

    /**
     * 通过token获取nickname
     * @param token
     * @return
     */
    public String getNicknameByToken(String token){
        String nickname;
        try {
            final Claims claims = parseJWT(token);
            nickname = claims.get(CLAIM_KEY_NICKNAME).toString();
        }catch (Exception e){
            nickname = null;
        }
        return nickname;
    }

    /**
     * 生成token
     * @param claims
     * @return
     */
    public String createToken(Map<String,Object> claims){
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, key);
        if (ttl > 0) {
            builder.setExpiration(new Date(System.currentTimeMillis() + ttl));
        }
        return builder.compact();
    }

    /**
     * 生成JWT
     *
     * @param id
     * @param subject
     * @return
     */
    public String createJWT(String id, String subject, String roles) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(id)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, key).claim("roles", roles);
        if (ttl > 0) {
            builder.setExpiration(new Date(nowMillis + ttl));
        }
        return builder.compact();
    }

    /**
     * 解析JWT
     *
     * @param jwtStr
     * @return
     */
    public Claims parseJWT(String jwtStr) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwtStr)
                .getBody();
    }
}