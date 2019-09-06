package com.seven.roast.dao;

import com.seven.roast.entity.Roast;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/6 5:42 PM
 * email  ：sevenryuu77@gmail.com
 */
public interface RoastDao extends MongoRepository<Roast, String> {

}
