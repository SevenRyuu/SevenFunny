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

    /**
     * 创建话题
     * @param topicInfo 【标题+内容+（标签）+用户id】
     * @return
     */
    @PostMapping(value = "/saveTopicInfo")
    public ResultResponse savaTopicInfo(TopicInfo topicInfo){
        topicInfoService.saveTopicInfo(topicInfo);
        return new ResultResponse(ResultCode.SUCCESS,null);
    }

    /**
     * 获取最新话题
     * @return
     */
    @PostMapping(value = "/getLatestTopics")
    public ResultResponse getLatestTopics(){
        return new ResultResponse(ResultCode.SUCCESS, topicInfoService.findLatestTopics());
    }
}
