package com.fstg.taxesejour.application.rest.api;


import com.fstg.taxesejour.application.dto.TaxeSejourAnnuelDto;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.TauxTaxeSejourPojo;
import com.fstg.taxesejour.domaine.process.tauxTaxe.create.CreateTauxTaxeInput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.fstg.taxesejour.utils.Constant.TAUX_TAXE;


@RequestMapping(value = TAUX_TAXE)
public interface TauxTaxeApi {

    @PostMapping(value = "/")
    Result save(@RequestBody CreateTauxTaxeInput createTauxTaxeInput);

    @GetMapping(value = "/")
    List<TaxeSejourAnnuelDto> findAll();

    @GetMapping("/date")
    public TauxTaxeSejourPojo findByCurrentDate();

//    @GetMapping(value = "/ref/{ref}")
//    @ApiOperation(value = "findByRef", notes = "findByRef", response = TaxeSejourAnnuelVO.class)
//    TaxeSejourAnnuelVO findByRef(@PathVariable String ref);

}
