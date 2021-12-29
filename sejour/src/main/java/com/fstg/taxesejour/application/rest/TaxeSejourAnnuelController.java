package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.dto.TaxeSejourAnnuelDto;
import com.fstg.taxesejour.application.rest.api.TaxeSejourAnnuelApi;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.process.taxeSejourAnnuel.create.CreateTaxeAnnuelInput;
import com.fstg.taxesejour.domaine.process.taxeSejourAnnuel.create.CreateTaxeAnnuelProcess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaxeSejourAnnuelController implements TaxeSejourAnnuelApi {
    private final CreateTaxeAnnuelProcess createTaxeAnnuelProcess;
    private final ModelMapper modelMapper;


    @Override
    public Result save(TaxeSejourAnnuelDto taxeSejourAnnuelDto) {
        CreateTaxeAnnuelInput createTaxeAnnuelInput = modelMapper.map(taxeSejourAnnuelDto, CreateTaxeAnnuelInput.class);
        return createTaxeAnnuelProcess.execute(createTaxeAnnuelInput);
    }
}
