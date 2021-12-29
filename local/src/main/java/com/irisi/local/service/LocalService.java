package com.irisi.local.service;

import com.irisi.local.bean.Local;
import com.irisi.local.rest.dto.LocalDto;

import java.util.List;


public interface LocalService {
   Local save(Local local);

   List<Local> findAll();

   Local findByRef(String ref);

   boolean existsByRef(String ref);

   Local update(Local local);

   boolean update(LocalDto localDto);
}
