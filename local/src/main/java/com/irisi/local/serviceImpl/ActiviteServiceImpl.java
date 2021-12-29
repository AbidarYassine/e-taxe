package com.irisi.local.serviceImpl;

import com.irisi.local.bean.Activite;
import com.irisi.local.dao.ActiviteDao;
import com.irisi.local.service.ActiviteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiviteServiceImpl implements ActiviteService {


    private final  ActiviteDao activiteDao;

    public ActiviteServiceImpl(ActiviteDao activiteDao) {
        this.activiteDao = activiteDao;
    }

    @Override
    public Activite save(Activite activite) {
        return activiteDao.save(activite);
    }

    @Override
    public List<Activite> findAll() {
        return activiteDao.findAll();
    }

    @Override
    public Activite findByRef(String ref) {
        return activiteDao.findByRef(ref);
    }
}
