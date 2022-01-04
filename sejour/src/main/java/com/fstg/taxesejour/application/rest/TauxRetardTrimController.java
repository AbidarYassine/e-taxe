package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.domaine.pojo.TauxRetardTaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;
import com.fstg.taxesejour.utils.Constant;
import com.fstg.taxesejour.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = Constant.TAUX_RETARD_TRIM_TAXE)
public class TauxRetardTrimController {

    private final TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public List<TauxRetardTaxeSejourTrim> findAll() {
        return tauxRetardTaxeSejourTrimInfra.findAll();
    }

    @PostMapping("/")
    public TauxRetardTaxeSejourTrim save(@RequestBody TauxRetardTaxeSejourTrimPojo tauxRetardTaxeSejourTrimPojo) {
        TauxRetardTaxeSejourTrim tauxRetardTaxeSejourTrim = new TauxRetardTaxeSejourTrim();
        tauxRetardTaxeSejourTrim.setAutreMoisRetard(tauxRetardTaxeSejourTrimPojo.getAutreMoisRetard());
        tauxRetardTaxeSejourTrim.setPremierMoisRetard(tauxRetardTaxeSejourTrimPojo.getPremierMoisRetard());
        tauxRetardTaxeSejourTrim.setRef(tauxRetardTaxeSejourTrimPojo.getRef());
        tauxRetardTaxeSejourTrim.setDateApplicationMax(Utils.stringToDate(tauxRetardTaxeSejourTrimPojo.getDateApplicationMax()));
        tauxRetardTaxeSejourTrim.setDateApplicationMin(Utils.stringToDate(tauxRetardTaxeSejourTrimPojo.getDateApplicationMin()));
        return tauxRetardTaxeSejourTrimInfra.save(tauxRetardTaxeSejourTrim);
    }

    @GetMapping("/date")
    public TauxRetardTaxeSejourTrimPojo getByCurrentDate() {
        return tauxRetardTaxeSejourTrimInfra.getTauxByCurrnetDate(new Date());
    }

}
