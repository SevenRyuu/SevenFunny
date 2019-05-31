package com.seven.topic.service;

import com.seven.topic.dao.TopicInfoMapper;
import com.seven.topic.entity.TopicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopicInfoService {

    @Autowired
    TopicInfoMapper topicInfoMapper;

    public void saveTopicInfo(TopicInfo topicInfo){
        topicInfo.setId("1");
        topicInfoMapper.insertTopicInfo(topicInfo);
    }
}
