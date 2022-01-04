package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.domaine.pojo.TauxRetardTaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.repository.TauxRetardTaxeSejourTrimRepository;
import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TauxRetardTaxeSejourTrimImpl implements TauxRetardTaxeSejourTrimInfra {

    private final TauxRetardTaxeSejourTrimRepository tauxRetardTaxeSejourTrimRepository;
    private final ModelMapper modelMapper;


    @Override
    public TauxRetardTaxeSejourTrim save(TauxRetardTaxeSejourTrim entity) {
        return tauxRetardTaxeSejourTrimRepository.save(entity);
    }

    @Override
    public List<TauxRetardTaxeSejourTrim> findAll() {
        return tauxRetardTaxeSejourTrimRepository.findAll();
    }


    @Override
    public TauxRetardTaxeSejourTrim findByRef(String ref) {
        return tauxRetardTaxeSejourTrimRepository.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return tauxRetardTaxeSejourTrimRepository.deleteByRef(ref);
    }

    @Override
    public boolean existsByRef(String ref) {
        return tauxRetardTaxeSejourTrimRepository.existsByRef(ref);
    }

    @Override
    public TauxRetardTaxeSejourTrimPojo getTauxByCurrnetDate(Date date) {
        return modelMapper.map(tauxRetardTaxeSejourTrimRepository.getTauxByCurrnetDate(date), TauxRetardTaxeSejourTrimPojo.class);
    }
}
