package com.seven.topic.dao.mapper;

import com.seven.topic.entity.TopicInfo;

import java.util.List;

public interface TopicInfoMapper {

    void insertTopicInfo(TopicInfo topicInfo);

    List<TopicInfo> findLatestTopics();

    List<TopicInfo> findAll();
}
