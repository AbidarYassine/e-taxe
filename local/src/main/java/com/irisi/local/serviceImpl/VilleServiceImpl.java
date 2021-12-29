package com.irisi.local.serviceImpl;

import com.irisi.local.bean.Ville;
import com.irisi.local.dao.VilleDao;
import com.irisi.local.service.VilleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleServiceImpl implements VilleService {


    private final  VilleDao villeDao;

    public VilleServiceImpl(VilleDao villeDao) {
        this.villeDao = villeDao;
    }

    @Override
    public Ville save(Ville ville) {
        return villeDao.save(ville);
    }

    @Override
    public List<Ville> findAll() {
        return villeDao.findAll();
    }
}
