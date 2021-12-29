package com.irisi.local.serviceImpl;

import com.irisi.local.bean.Local;
import com.irisi.local.dao.LocalDao;
import com.irisi.local.rest.dto.LocalDto;
import com.irisi.local.service.ActiviteService;
import com.irisi.local.service.LocalService;
import com.irisi.local.service.RedevableService;
import com.irisi.local.service.RueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LocalServiceImpl implements LocalService {

    private final LocalDao localDao;
    private  final RedevableService redevableService;
    private  final RueService rueService;
    private  final ActiviteService activiteService;

    public LocalServiceImpl(LocalDao localDao, RedevableService redevableService, RueService rueService, ActiviteService activiteService) {
        this.localDao = localDao;
        this.redevableService = redevableService;
        this.rueService = rueService;
        this.activiteService = activiteService;
    }


    @Override
    public Local save(Local local) {
        /*Redevable redevable = redevableService.findByRef(refRedevable);
        Activite activite = activiteService.findByRef(refActivite);
        Rue rue =rueService.findByRef(refRue);
        local.setRedevable(redevable);
        local.setActivite(activite);
        local.setRue(rue);*/
        return localDao.save(local);
    }

    @Override
    public List<Local> findAll() {
        return localDao.findAll();
    }

    @Override
    public Local findByRef(String ref) {
        return localDao.findByRef(ref);
    }

    @Override
    public boolean existsByRef(String ref) {
        return localDao.existsByRef(ref);
    }

    @Override
    public Local update(Local local) {
        return localDao.save(local);
    }

    @Override
    public boolean update(LocalDto localDto) {
        Local local = localDao.findByRef(localDto.getRef());
        if (local == null) return false;
        local.setDernierAnneePayer(localDto.getDernierAnneePayer());
        local.setDernierTrimPayer(localDto.getDernierTrimPayer());
        localDao.save(local);
        return true;
    }
}
