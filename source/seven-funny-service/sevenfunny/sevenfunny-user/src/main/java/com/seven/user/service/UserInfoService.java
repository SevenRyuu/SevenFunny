package com.seven.user.service;

import com.seven.user.dao.UserInfoMapper;
import com.seven.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.seven.common.entity.util.IdWorker;

import java.util.concurrent.TimeUnit;

/**
 * @author ：SevenRyuu
 * date   ：2019/5/30 9:26 PM
 * email  ：sevenryuu77@gmail.com
 */
@Service
@Transactional
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    IdWorker idWorker;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 用户注册
     * @param userInfo
     */
    public void register(UserInfo userInfo){
        userInfo.setId(idWorker.nextId()+"");
        //密码加密
        String encodePassword = encoder.encode(userInfo.getPassword());
        userInfo.setPassword(encodePassword);

        userInfoMapper.insertUserInfo(userInfo);
    }

    public UserInfo findByMobileAndPassword(String mobile, String password){
        UserInfo userInfo = userInfoMapper.findByMobile(mobile);

        if(userInfo != null && encoder.matches(password,userInfo.getPassword())){
            return userInfo;
        }
        return null;
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public UserInfo findById(String id) {

        //从缓存中读取
        UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get("user_"+id);
        //如果缓存没有则到数据库查询并放入缓存
        if(userInfo == null){
            userInfo = userInfoMapper.findById(id);
            redisTemplate.opsForValue().set("user_"+id,userInfo,10,TimeUnit.SECONDS);
        }

        return userInfo;
    }

    /**
     * 根据手机号获取用户信息
     * @param mobile
     * @return
     */
    public UserInfo findByMobile(String mobile){
        return userInfoMapper.findByMobile(mobile);
    }

    public void delById(String id){
        redisTemplate.delete("user_"+id);
        userInfoMapper.deleteById(id);
    }

    @Cacheable(value="userCache_",key="#mobile")
    public UserInfo findByMobileCache(String mobile){
        return userInfoMapper.findByMobile(mobile);
    }

    @CacheEvict(value="userCache_",key="#mobile")
    public void delByMobileCache(String mobile){
        userInfoMapper.deleteByMobile(mobile);
    }
}
