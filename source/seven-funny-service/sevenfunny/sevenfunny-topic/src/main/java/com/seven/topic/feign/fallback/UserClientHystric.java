package com.seven.topic.feign.fallback;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.topic.feign.UserClient;
import org.springframework.stereotype.Component;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/10 11:06 AM
 * email  ：sevenryuu77@gmail.com
 * info   ：
 */
@Component
public class UserClientHystric implements UserClient {
    @Override
    public ResultResponse testFeign(String x) {
        return new ResultResponse(ResultCode.ERROR);
    }
}
