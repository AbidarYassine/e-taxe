package com.irisi.local.serviceImpl;

import com.irisi.local.bean.Declaration;
import com.irisi.local.dao.DeclarationDao;
import com.irisi.local.service.DeclarationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationServiceImpl implements DeclarationService {


    private final  DeclarationDao declarationDao;

    public DeclarationServiceImpl(DeclarationDao declarationDao) {
        this.declarationDao = declarationDao;
    }

    @Override
    public Declaration save(Declaration declaration) {
        return declarationDao.save(declaration);
    }

    @Override
    public List<Declaration> findAll() {
        return declarationDao.findAll();
    }
}
