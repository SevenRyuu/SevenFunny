package com.seven.user.dao;

import com.seven.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：SevenRyuu
 * date   ：2019/5/27 9:55 PM
 * email  ：sevenryuu77@gmail.com
 */
public interface UserInfoMapper {

    UserInfo findById(String id);

    UserInfo findByMobileAndPassword(String mobile, String password);

    UserInfo findByMobile(String mobile);

    void insertUserInfo(UserInfo userInfo);

    void deleteById(String id);

    void deleteByMobile(String mobile);

    int checkMobileCnt(String mobile);

    int checkNicknameCnt(String nickname);

    void updateUserInfo(UserInfo userInfo);

    void changePassword(@Param("id") String id, @Param("password") String password);
}
