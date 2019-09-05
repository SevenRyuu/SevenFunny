package com.seven.search.controller;


import com.seven.common.entity.PageResult;
import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.search.entity.TopicInfo;
import com.seven.search.service.TopicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public ResultResponse savaTopicInfo(@RequestBody TopicInfo topicInfo){
        topicInfoService.saveTopicInfo(topicInfo);
        return new ResultResponse(ResultCode.SUCCESS);
    }

    /**
     * 根据关键字查询
     * @param keywords
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/search/{keywords}/{pageNum}/{pageSize}")
    public ResultResponse findByKeywords(@PathVariable String keywords, @PathVariable int pageNum, @PathVariable int pageSize){

        Page<TopicInfo> pageInfo = topicInfoService.findByKeywords(keywords, pageNum, pageSize);

        return new ResultResponse(ResultCode.SUCCESS, new PageResult<TopicInfo>(pageInfo.getTotalElements(), pageInfo.getContent()));
    }
}
