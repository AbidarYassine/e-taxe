package com.irisi.local.serviceImpl;

import com.irisi.local.bean.Commune;
import com.irisi.local.dao.CommuneDao;
import com.irisi.local.service.CommuneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneServiceImpl implements CommuneService {


    private final  CommuneDao communeDao;

    public CommuneServiceImpl(CommuneDao communeDao) {
        this.communeDao = communeDao;
    }

    @Override
    public Commune save(Commune commune) {
        return communeDao.save(commune);
    }

    @Override
    public List<Commune> findAll() {
        return communeDao.findAll();
    }
}
