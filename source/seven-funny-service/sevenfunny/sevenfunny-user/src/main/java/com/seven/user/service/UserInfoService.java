package com.seven.user.service;

import com.seven.user.dao.UserInfoMapper;
import com.seven.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public UserInfo getUserInfo(UserInfo userInfo){
        return userInfoMapper.selectByPrimaryKey(userInfo.getId());
    }
}
