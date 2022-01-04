package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.dto.TaxeSejourAnnuelDto;
import com.fstg.taxesejour.application.rest.api.TauxTaxeApi;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.TauxTaxeSejourPojo;
import com.fstg.taxesejour.domaine.process.tauxTaxe.create.CreateTauxTaxeInput;
import com.fstg.taxesejour.domaine.process.tauxTaxe.create.CreateTauxTaxeProcess;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TauxTaxeController implements TauxTaxeApi {

    private final TauxTaxeSejourInfra tauxTaxeSejourInfra;
    private final CreateTauxTaxeProcess createTauxTaxeProcess;
    private final ModelMapper modelMapper;

    @Override
    public Result save(CreateTauxTaxeInput createTauxTaxeInput) {
        log.info("adding new taux taxe sejour ...");
        return createTauxTaxeProcess.execute(createTauxTaxeInput);
    }

    @Override
    public List<TaxeSejourAnnuelDto> findAll() {
        return tauxTaxeSejourInfra.findAll().stream().map(el -> modelMapper.map(el, TaxeSejourAnnuelDto.class)).toList();
    }

    public TauxTaxeSejourPojo findByCurrentDate() {
        return tauxTaxeSejourInfra.getCurrentTauxTaxe(new Date());
    }
}
