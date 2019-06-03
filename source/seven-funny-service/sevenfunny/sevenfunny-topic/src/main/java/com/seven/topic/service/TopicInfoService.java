package com.seven.topic.service;

import com.seven.topic.dao.TopicInfoMapper;
import com.seven.topic.entity.TopicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopicInfoService {

    @Autowired
    TopicInfoMapper topicInfoMapper;

    /**
     * 保存话题
     * @param topicInfo
     */
    public void saveTopicInfo(TopicInfo topicInfo){
        //topicInfo.setId("1");
        topicInfoMapper.insertTopicInfo(topicInfo);
    }

    /**
     * 获取按修改时间倒序前十条数据
     * @return
     */
    public List<TopicInfo> findLatestTopics(){
        List<TopicInfo> topicInfos = topicInfoMapper.findLatestTopics();
        return topicInfos;
    }
}
