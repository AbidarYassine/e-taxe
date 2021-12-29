package com.irisi.local.service;

import com.irisi.local.bean.Activite;

import java.util.List;


public interface ActiviteService {
   Activite save(Activite activite);
   List<Activite> findAll();
   Activite findByRef(String ref);

}
