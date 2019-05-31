package com.seven.topic.controller;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.topic.entity.TopicInfo;
import com.seven.topic.service.TopicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicInfoController {

    @Autowired
    TopicInfoService topicInfoService;

    @PostMapping(value = "/saveTopicInfo")
    public ResultResponse savaTopicInfo(TopicInfo topicInfo){
        topicInfoService.saveTopicInfo(topicInfo);
        ResultResponse resultResponse = new ResultResponse(ResultCode.SUCCESS,null);
        return resultResponse;
    }
}
