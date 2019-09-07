package com.seven.topic;

import com.seven.topic.entity.TopicComment;
import com.seven.topic.entity.TopicInfo;
import com.seven.topic.service.TopicCommentService;
import com.seven.topic.service.TopicInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SevenfunnyTopicApplicationTests {

    @Autowired
    private TopicInfoService topicInfoService;

    @Autowired
    private TopicCommentService topicCommentService;

    @Test
    public void contextLoads() {
    }

    @Test
    @Rollback(value = false)
    public void cycleInertTopicInfo(){
        for(int i = 1;i < 100;i++){
            TopicInfo topicInfo = new TopicInfo();
            topicInfo.setTitle("标题"+i);
            topicInfo.setContent("内容"+i);
            topicInfo.setLabel("标签"+i);
            topicInfoService.saveTopicInfo(topicInfo);
        }
    }

    @Test
    @Rollback(value = false)
    public void cycleInertTopicComment(){
        for(int i = 1;i < 20;i++){
            TopicComment topicComment = new TopicComment();
            topicComment.setTopic_id(String.valueOf(i));
            topicComment.setContent("内容"+i);
            topicComment.setTopic_type("类型"+i);
            topicComment.setFrom_uid(""+i);
            topicComment.setReg_dt(new Date());
            topicCommentService.save(topicComment);
        }
    }

}
