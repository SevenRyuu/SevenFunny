package com.seven.user;

import com.seven.user.dao.UserInfoMapper;
import com.seven.user.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SevenfunnyUserApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    public void testSelect() {
        List<UserInfo> uis = userInfoMapper.selectByPrimaryKey();
        uis.forEach(userInfo -> {
            System.out.println("昵称：" + userInfo.getNickname());
        });


        /*UserInfo ui = userInfoMapper.selectByPrimaryKey();
        System.out.println("昵称：" + ui.getNickname());*/
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testInsert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("7");
        userInfoMapper.insertUserInfo(userInfo);
    }

}
