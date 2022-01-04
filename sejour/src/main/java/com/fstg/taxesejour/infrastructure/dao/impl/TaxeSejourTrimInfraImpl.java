package com.fstg.taxesejour.infrastructure.dao.impl;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.repository.TaxeSejourTrimRepository;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class TaxeSejourTrimInfraImpl implements TaxeSejourTrimInfra {
    private final TaxeSejourTrimRepository taxeSejourTrimRepository;
    private final ModelMapper modelMapper;




    @Override
    public List<TaxeSejourTrimPojo> findAll() {
        return taxeSejourTrimRepository.findAll().stream().map(e -> modelMapper.map(e, TaxeSejourTrimPojo.class)).collect(Collectors.toList());
    }


    @Override
    public TaxeSejourTrimPojo findByRef(String ref) {
        TaxeSejourTrim sejourTrim = taxeSejourTrimRepository.findByRef(ref);
        return modelMapper.map(sejourTrim, TaxeSejourTrimPojo.class);
    }

    @Override
    public int deleteByRef(String ref) {
        return taxeSejourTrimRepository.deleteByRef(ref);
    }

    @Override
    public boolean existeByRef(String ref) {
        return taxeSejourTrimRepository.existsByRef(ref);
    }

    @Override
    public TaxeSejourTrimPojo findByAnnee(int annee) {
        TaxeSejourTrim sejourTrim = taxeSejourTrimRepository.findByAnnee(annee);
        return modelMapper.map(sejourTrim, TaxeSejourTrimPojo.class);
    }

    @Override
    public boolean existsByAnneeAndNumTrim(int annee, int numTrim) {
        return taxeSejourTrimRepository.existsByAnneeAndNumTrim(annee, numTrim);
    }


    @Override
    public TaxeSejourTrimPojo save(TaxeSejourTrimPojo taxeSejourTrimPojo) {
        log.info("data recived {}", taxeSejourTrimPojo);
        TaxeSejourTrim taxeSejourTrim = modelMapper.map(taxeSejourTrimPojo, TaxeSejourTrim.class);
        taxeSejourTrim.setDatePresentation(new Date());
        log.info("after  convert {}", taxeSejourTrim);
        TaxeSejourTrim sejourTrimSaved = taxeSejourTrimRepository.save(taxeSejourTrim);
        return modelMapper.map(sejourTrimSaved, TaxeSejourTrimPojo.class);
    }
}
