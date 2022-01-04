package com.irisi.local.service;

import com.irisi.local.bean.Commune;

import java.util.List;


public interface CommuneService {
   Commune save(Commune commune);
   List<Commune> findAll();
}
