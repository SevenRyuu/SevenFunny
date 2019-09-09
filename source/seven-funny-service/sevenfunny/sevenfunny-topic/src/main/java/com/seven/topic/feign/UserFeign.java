package com.seven.topic.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/9 9:16 PM
 * email  ：sevenryuu77@gmail.com
 * info   ：topic调用user
 */
@FeignClient(value = "sevenfunny-user")
public interface UserFeign {

    @RequestMapping(value = "/user/login/topicFeign",method = RequestMethod.GET)
    public void testFeign(@RequestParam(value = "x") String x);
}
