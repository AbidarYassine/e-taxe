package com.irisi.local.service;

import com.irisi.local.bean.Rue;

import java.util.List;


public interface RueService {
   Rue save(Rue rue);
   List<Rue> findAll();
   Rue findByRef(String ref);

}
