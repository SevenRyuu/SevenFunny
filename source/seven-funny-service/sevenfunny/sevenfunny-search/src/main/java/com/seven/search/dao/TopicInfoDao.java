package com.seven.search.dao;

import com.seven.search.entity.TopicInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/5 9:18 PM
 * email  ：sevenryuu77@gmail.com
 */
public interface TopicInfoDao extends ElasticsearchCrudRepository<TopicInfo, String> {

    public Page<TopicInfo> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
