package com.seven.roast.service;

import com.seven.roast.dao.RoastDao;
import com.seven.roast.entity.Roast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/6 5:43 PM
 * email  ：sevenryuu77@gmail.com
 */
@Service
@Transactional
public class RoastService {

    @Autowired
    private RoastDao roastDao;

    @Autowired
    private com.seven.common.entity.util.IdWorker idWorker;

    public List<Roast> findAll(){
        return roastDao.findAll();
    }

    public Roast findById(String id){
        return roastDao.findById(id).get();
    }

    public void save(Roast roast){
        roast.set_id(idWorker.nextId()+"");
        roastDao.save(roast);
    }

    public void update(Roast roast){
        roastDao.save(roast);
    }

    public void deleteById(String id){
        roastDao.deleteById(id);
    }
}
