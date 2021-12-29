package com.irisi.local.service;

import com.irisi.local.bean.AnnexAdministrative;

import java.util.List;


public interface AnnexAdministrativeService {
   AnnexAdministrative save(AnnexAdministrative annexAdministrative);
   List<AnnexAdministrative> findAll();
}
