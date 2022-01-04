package com.irisi.local.serviceImpl;

import com.irisi.local.bean.Zone;
import com.irisi.local.dao.ZoneDao;
import com.irisi.local.service.ZoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {


    private final  ZoneDao zoneDao;

    public ZoneServiceImpl(ZoneDao zoneDao) {
        this.zoneDao = zoneDao;
    }

    @Override
    public Zone save(Zone zone) {
        return zoneDao.save(zone);
    }

    @Override
    public List<Zone> findAll() {
        return zoneDao.findAll();
    }
}
