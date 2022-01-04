package com.irisi.local.serviceImpl;

import com.irisi.local.bean.Rue;
import com.irisi.local.dao.RueDao;
import com.irisi.local.service.RueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RueServiceImpl implements RueService {


    private final  RueDao rueDao;

    public RueServiceImpl(RueDao rueDao) {
        this.rueDao = rueDao;
    }

    @Override
    public Rue save(Rue rue) {
        return rueDao.save(rue);
    }

    @Override
    public List<Rue> findAll() {
        return rueDao.findAll();
    }

    @Override
    public Rue findByRef(String ref) {
        return  rueDao.findByRef(ref);
    }
}
