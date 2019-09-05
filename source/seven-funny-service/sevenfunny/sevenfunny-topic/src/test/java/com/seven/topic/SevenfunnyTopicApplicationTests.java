package com.seven.topic;

import com.seven.topic.entity.TopicInfo;
import com.seven.topic.service.TopicInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SevenfunnyTopicApplicationTests {

    @Autowired
    private TopicInfoService topicInfoService;

    @Test
    public void contextLoads() {
    }

    @Test
    @Rollback(value = false)
    public void cycleInert(){
        for(int i = 1;i < 100;i++){
            TopicInfo topicInfo = new TopicInfo();
            topicInfo.setTitle("标题"+i);
            topicInfo.setContent("内容"+i);
            topicInfo.setLabel("标签"+i);
            topicInfoService.saveTopicInfo(topicInfo);
        }
    }

}
