package com.seven.user;

/**
 * @author ：SevenRyuu
 * date   ：2019/6/7 3:49 PM
 * email  ：sevenryuu77@gmail.com
 */
public class MainTest {

    /*public static void main(String[] args) throws JsonProcessingException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        ObjectMapper objectMapper = new ObjectMapper();
       *//* Class a = ResultCode.class;
        Object[] aa = a.getEnumConstants();


        for(Object bb : aa){
            //System.out.println(bb);
            if(bb.toString().equals("ERROR")){
                System.out.println(objectMapper.writeValueAsString(new ResultResponse((ResultCode) bb)));
            }
        }*//*

        ResultCode resultCode = ResultCode.valueOf("ERROR");
        System.out.println(resultCode.code());
        System.out.println(resultCode.message());
        System.out.println(objectMapper.writeValueAsString(new ResultResponse(resultCode)));
        System.out.println(new ResultResponse(ResultCode.ERROR));
    }*/
}
