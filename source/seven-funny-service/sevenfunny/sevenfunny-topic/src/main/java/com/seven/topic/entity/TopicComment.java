package com.seven.topic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/7 10:49 AM
 * email  ：sevenryuu77@gmail.com
 * info   ：话题评论实体类
 */
@Entity
@Table(name = "sf_topic_comment")
public class TopicComment {

    @Id
    private String id;//话题评论id

    private String topic_id;//话题id

    private String topic_type;//话题类型

    private String content;//评论内容

    private String from_uid;//评论用户id

    private Date reg_dt;//录入时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_type() {
        return topic_type;
    }

    public void setTopic_type(String topic_type) {
        this.topic_type = topic_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom_uid() {
        return from_uid;
    }

    public void setFrom_uid(String from_uid) {
        this.from_uid = from_uid;
    }

    public Date getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(Date reg_dt) {
        this.reg_dt = reg_dt;
    }
}
