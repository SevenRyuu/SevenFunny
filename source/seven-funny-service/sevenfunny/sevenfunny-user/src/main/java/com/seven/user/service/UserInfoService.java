package com.seven.user.service;

import com.seven.common.entity.util.IdWorker;
import com.seven.common.exception.SevenFunnyException;
import com.seven.user.dao.UserInfoMapper;
import com.seven.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 验证手机号密码是否匹配
     * @param mobile
     * @param password
     * @return
     */
    public UserInfo checkMobilePassword(String mobile, String password){
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
        /*UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get("user_"+id);
        //如果缓存没有则到数据库查询并放入缓存
        if(userInfo == null){
            userInfo = userInfoMapper.findById(id);
            redisTemplate.opsForValue().set("user_"+id,userInfo,30,TimeUnit.MINUTES);
        }*/

        return userInfoMapper.findById(id);
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

    /**
     * 验证手机号是否存在
     * @param mobile
     * @return
     */
    public int checkMobileCnt(String mobile){
        return userInfoMapper.checkMobileCnt(mobile);
    }

    /**
     * 验证昵称是否存在
     * @param nickname
     * @return
     */
    public int checkNicknameCnt(String nickname){
        return userInfoMapper.checkNicknameCnt(nickname);
    }

    /**
     * 更新用户基本信息 【头像+简介】
     * @param userInfo
     */
    public void updateUserInfo(UserInfo userInfo){
        redisTemplate.delete("user_"+userInfo.getId());
        userInfoMapper.updateUserInfo(userInfo);
        //updateUserInfo2();
        //int a = 1/0;
    }

    public void updateUserInfo2(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1136886166935703552");
        userInfo.setAvatar("testAvatar");
        userInfo.setIntro("test简介");
        userInfoMapper.updateUserInfo(userInfo);
    }

    /**
     * 修改用户密码
     * @param id
     * @param oldPassword
     * @param newPassword
     */
    public void changePassword(String id, String oldPassword, String newPassword){
        //redisTemplate.delete("user_"+id);
        UserInfo userInfo = userInfoMapper.findById(id);
        if (userInfo == null){
            //用户不存在
            throw new SevenFunnyException("USER_NOT_LOGGED_IN");
        }
        if(!encoder.matches(oldPassword, userInfo.getPassword())){
            //密码错误
            throw new SevenFunnyException("USER_PASSWORD_ERROR");
        }
        userInfoMapper.changePassword(id, encoder.encode(newPassword));
    }
}
