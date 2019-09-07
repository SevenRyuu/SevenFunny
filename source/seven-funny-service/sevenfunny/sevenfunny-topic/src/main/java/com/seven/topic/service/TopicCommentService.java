package com.seven.topic.service;

import com.seven.common.exception.SevenFunnyException;
import com.seven.topic.dao.repository.TopicCommentRepository;
import com.seven.topic.entity.TopicComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/7 11:13 AM
 * email  ：sevenryuu77@gmail.com
 * info   ：话题评论服务层
 */
@Service
@Transactional
public class TopicCommentService {

    @Autowired
    private TopicCommentRepository topicCommentRepository;

    @Autowired
    private com.seven.common.entity.util.IdWorker idWorker;

    /**
     * 新增话题评论
     * @param topicComment
     */
    public void save(TopicComment topicComment){
        topicComment.setId(idWorker.nextId()+"");
        topicComment.setReg_dt(new Date());
        topicCommentRepository.save(topicComment);
    }

    /**
     * 修改话题评论
     * @param topicComment
     */
    public void update(TopicComment topicComment){
        topicCommentRepository.save(topicComment);
    }

    /**
     * 删除话题评论
     * @param topicCommentId
     */
    public void deleteById(String topicCommentId){
        topicCommentRepository.deleteById(topicCommentId);
    }

    /**
     * 查询所有话题评论
     * @return
     */
    public List<TopicComment> findAll(){
        return topicCommentRepository.findAll();
    }

    /**
     * 根据Id查询话题评论
     * @param id
     * @return
     */
    public TopicComment findById(String id){
        TopicComment topicComment = null;
        try{
            topicComment = topicCommentRepository.findById(id).get();
        }catch (Exception e){
            throw new SevenFunnyException("TOPIC_NOT_EXIST");
        }
        return topicComment;
    }
}
