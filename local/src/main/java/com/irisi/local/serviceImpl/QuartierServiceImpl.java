package com.irisi.local.serviceImpl;

import com.irisi.local.bean.Quartier;
import com.irisi.local.dao.QuartierDao;
import com.irisi.local.service.QuartierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartierServiceImpl implements QuartierService {


    private final  QuartierDao quartierDao;

    public QuartierServiceImpl(QuartierDao quartierDao) {
        this.quartierDao = quartierDao;
    }

    @Override
    public Quartier save(Quartier quartier) {
        return quartierDao.save(quartier);
    }

    @Override
    public List<Quartier> findAll() {
        return quartierDao.findAll();
    }
}
