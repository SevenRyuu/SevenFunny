package com.seven.search.service;


import com.seven.search.dao.TopicInfoDao;
import com.seven.search.entity.TopicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopicInfoService {

    @Autowired
    private TopicInfoDao topicInfoDao;

    @Autowired
    com.seven.common.entity.util.IdWorker idWorker;

    /**
     * 保存话题
     * @param topicInfo
     */
    public void saveTopicInfo(TopicInfo topicInfo){
        topicInfo.setId(idWorker.nextId()+"");
        topicInfoDao.save(topicInfo);
    }

    /**
     * 根据关键字获取话题
     * @param keywords
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<TopicInfo> findByKeywords(String keywords, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return topicInfoDao.findByTitleOrContentLike(keywords, keywords, pageable);
    }
}
