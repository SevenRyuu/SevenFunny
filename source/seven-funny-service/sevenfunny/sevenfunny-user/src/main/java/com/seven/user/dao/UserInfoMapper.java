package com.seven.user.dao;

import com.seven.user.entity.UserInfo;

import java.util.List;

/**
 * @author ：SevenRyuu
 * date   ：2019/5/27 9:55 PM
 * email  ：sevenryuu77@gmail.com
 */
public interface UserInfoMapper {

    UserInfo selectByPrimaryKey(String id);

    void insertUserInfo(UserInfo userInfo);
}
