package com.irisi.local.serviceImpl;

import com.irisi.local.bean.AnnexAdministrative;
import com.irisi.local.dao.AnnexAdministrativeDao;
import com.irisi.local.service.AnnexAdministrativeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnexAdministrativeServiceImpl implements AnnexAdministrativeService {


    private final  AnnexAdministrativeDao annexAdministrativeDao;

    public AnnexAdministrativeServiceImpl(AnnexAdministrativeDao annexAdministrativeDao) {
        this.annexAdministrativeDao = annexAdministrativeDao;
    }

    @Override
    public AnnexAdministrative save(AnnexAdministrative annexAdministrative) {
        return annexAdministrativeDao.save(annexAdministrative);
    }

    @Override
    public List<AnnexAdministrative> findAll() {
        return annexAdministrativeDao.findAll();
    }
}
