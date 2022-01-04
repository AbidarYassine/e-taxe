package com.irisi.local.service;

import com.irisi.local.bean.Declaration;

import java.util.List;


public interface DeclarationService {
   Declaration save(Declaration declaration);
   List<Declaration> findAll();
}
