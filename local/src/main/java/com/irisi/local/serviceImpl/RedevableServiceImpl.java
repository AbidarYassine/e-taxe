package com.irisi.local.serviceImpl;

import com.irisi.local.service.RedevableService;
import com.irisi.local.bean.Redevable;
import com.irisi.local.dao.RedevableDao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedevableServiceImpl implements RedevableService {


    private final RedevableDao redevableDao;

    public RedevableServiceImpl(RedevableDao redevableDao) {
        this.redevableDao = redevableDao;
    }


    @Override
    public Redevable save(Redevable redevable) {

        return redevableDao.save(redevable);
    }

    @Override
    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }


    @Override
    public Redevable update(Redevable Redevable) {
        return redevableDao.save(Redevable);
    }

    @Override
    public Redevable findByRef(String ref) {
        return redevableDao.findByRef(ref);
    }

}
