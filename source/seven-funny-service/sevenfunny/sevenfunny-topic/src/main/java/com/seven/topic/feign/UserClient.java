package com.seven.topic.feign;

import com.seven.common.entity.ResultResponse;
import com.seven.topic.feign.fallback.UserClientHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/9 9:16 PM
 * email  ：sevenryuu77@gmail.com
 * info   ：topic调用user
 */
@FeignClient(value = "sevenfunny-user", fallback = UserClientHystric.class)
public interface UserClient {

    @GetMapping(value = "/user/topicFeign")
    ResultResponse testFeign(@RequestParam(value = "x") String x);
}
