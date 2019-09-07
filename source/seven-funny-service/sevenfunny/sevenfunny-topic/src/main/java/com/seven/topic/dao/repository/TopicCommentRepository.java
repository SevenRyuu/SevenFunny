package com.seven.topic.dao.repository;

import com.seven.topic.entity.TopicComment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/7 11:10 AM
 * email  ：sevenryuu77@gmail.com
 * info   ：话题评论数据访问JPA
 */
public interface TopicCommentRepository extends JpaRepository<TopicComment, String> {
}
