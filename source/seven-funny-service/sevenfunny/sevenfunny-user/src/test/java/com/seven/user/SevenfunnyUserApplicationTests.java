package com.seven.user;

import com.seven.user.dao.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SevenfunnyUserApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void contextLoads() {
    }

    /*@Test
    @Transactional
    public void testSelect() {
        List<UserInfo> uis = userInfoMapper.selectByPrimaryKey();
        uis.forEach(userInfo -> {
            System.out.println("昵称：" + userInfo.getNickname());
        });


        *//*UserInfo ui = userInfoMapper.selectByPrimaryKey();
        System.out.println("昵称：" + ui.getNickname());*//*
    }*/

    /*@Test
    @Transactional
    @Rollback(value = false)
    public void testInsert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("7");
        userInfoMapper.insertUserInfo(userInfo);
    }*/

    /*@Test
    public void testInvokeEnum() throws JsonProcessingException {
        //Class<?> aClass = Class.forName("com.seven.common.entity.ResultCode");

        //Object[] oo = aClass.getEnumConstants();
        //Object invoke = getMeaning.invoke(oo[0],"0");

        //Gson gson = new Gson();
        //ObjectMapper objectMapper = new ObjectMapper();
        Class a = ResultCode.class;
        //Method method = a.getDeclaredMethod("ERROR");
        //method.invoke();
        Object[] aa = a.getEnumConstants();
        for(Object bb : aa){
            if(bb.equals("ERROR")){
                //System.out.println(gson.toJson(bb));
                System.out.println(bb);
                //System.out.println(objectMapper.writeValueAsString(bb));
            }
        }

        //System.out.println(ResultCode.valueOf("PARAM_IS_BLANK"));
    }*/

}
