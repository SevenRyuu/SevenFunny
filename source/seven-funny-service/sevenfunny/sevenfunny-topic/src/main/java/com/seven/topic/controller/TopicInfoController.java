package com.seven.topic.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.seven.common.entity.PageResult;
import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.topic.entity.TopicInfo;
import com.seven.topic.feign.UserClient;
import com.seven.topic.service.TopicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
public class TopicInfoController {

    @Autowired
    private TopicInfoService topicInfoService;

    @Autowired
    private UserClient userClient;

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

    /**
     * 分页获取所有话题
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping
    public ResultResponse findAll(@RequestParam(required = false)Integer pageNum, @RequestParam(required = false)Integer pageSize){
        Page<TopicInfo> page = PageHelper.startPage(pageNum, pageSize);
        topicInfoService.findAll();
        //PageInfo<TopicInfo> pageInfo = new PageInfo<>(list);
        return new ResultResponse(ResultCode.SUCCESS, new PageResult<TopicInfo>(page.getTotal(), page.getResult()));
    }

    /**
     * 测试feign
     * @param x
     */
    @GetMapping(value = "/testFeign")
    public ResultResponse testFeign(@RequestParam String x){
        userClient.testFeign(x);
        return null;
    }
}
