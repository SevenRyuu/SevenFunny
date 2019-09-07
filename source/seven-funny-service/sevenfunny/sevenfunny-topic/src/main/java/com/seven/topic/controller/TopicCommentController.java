package com.seven.topic.controller;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.topic.entity.TopicComment;
import com.seven.topic.service.TopicCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/7 10:53 AM
 * email  ：sevenryuu77@gmail.com
 * info   ：话题评论控制层
 */
@RestController
@RequestMapping ("/topic/comment")
public class TopicCommentController {

    @Autowired
    private TopicCommentService topicCommentService;

    /**
     * 新增话题评论
     * @param topicComment
     * @return
     */
    @PostMapping
    public ResultResponse save(@RequestBody TopicComment topicComment) {
        topicCommentService.save(topicComment);
        return new ResultResponse(ResultCode.SUCCESS);
    }

    /**
     * 修改话题评论
     * @param id
     * @param topicComment
     * @return
     */
    @PutMapping
    public ResultResponse update(@RequestParam String id, @RequestBody TopicComment topicComment) {
        topicComment.setId(id);
        topicCommentService.update(topicComment);
        return new ResultResponse(ResultCode.SUCCESS);
    }

    /**
     * 删除话题评论
     * @param id
     * @return
     */
    @DeleteMapping
    public ResultResponse deleteById(@RequestParam String id) {
        topicCommentService.deleteById(id);
        return new ResultResponse(ResultCode.SUCCESS);
    }

    /**
     * 查询所有话题评论
     * @return
     */
    @GetMapping
    public ResultResponse findAll(){
        return new ResultResponse(ResultCode.SUCCESS, topicCommentService.findAll());
    }

    /**
     * 根据id查询话题评论
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResultResponse findById(@PathVariable String id){
        return new ResultResponse(ResultCode.SUCCESS, topicCommentService.findById(id));
    }
}
