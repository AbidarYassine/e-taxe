package com.irisi.local.service;

import com.irisi.local.bean.Ville;

import java.util.List;


public interface VilleService {
   Ville save(Ville ville);
   List<Ville> findAll();
}
