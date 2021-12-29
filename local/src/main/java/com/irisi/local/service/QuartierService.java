package com.irisi.local.service;

import com.irisi.local.bean.Local;
import com.irisi.local.bean.Quartier;

import java.util.List;


public interface QuartierService {
   Quartier save(Quartier quartier);
   List<Quartier> findAll();
}
