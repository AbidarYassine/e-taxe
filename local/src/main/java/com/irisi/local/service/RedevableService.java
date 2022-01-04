package com.irisi.local.service;

import com.irisi.local.bean.Redevable;

import java.util.List;


public interface RedevableService {
   Redevable save(Redevable redevable);
   List<Redevable> findAll();
   Redevable update(Redevable redevable);
   Redevable findByRef(String ref);


}
