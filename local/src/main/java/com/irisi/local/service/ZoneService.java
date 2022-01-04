package com.irisi.local.service;

import com.irisi.local.bean.Zone;

import java.util.List;


public interface ZoneService {
   Zone save(Zone zone);
   List<Zone> findAll();
}
