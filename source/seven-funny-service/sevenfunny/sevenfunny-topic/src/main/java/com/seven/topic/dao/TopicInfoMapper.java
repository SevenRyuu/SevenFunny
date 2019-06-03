package com.seven.topic.dao;

import com.seven.topic.entity.TopicInfo;

import java.util.List;

public interface TopicInfoMapper {

    void insertTopicInfo(TopicInfo topicInfo);

    List<TopicInfo> findLatestTopics();
}
