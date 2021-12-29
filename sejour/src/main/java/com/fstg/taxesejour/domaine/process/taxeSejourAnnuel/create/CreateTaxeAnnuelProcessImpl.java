package com.fstg.taxesejour.domaine.process.taxeSejourAnnuel.create;

import com.fstg.taxesejour.domaine.core.AbstractProcessImpl;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourAnnuelePojo;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelInfra;
import com.fstg.taxesejour.infrastructure.messaging.LocalMessageReader;
import com.fstg.taxesejour.infrastructure.required.LocalService;

import java.util.Date;

public class CreateTaxeAnnuelProcessImpl extends AbstractProcessImpl<CreateTaxeAnnuelInput> implements CreateTaxeAnnuelProcess {

    private final TaxeSejourAnnuelInfra taxeSejourAnnuelInfra;
    private final LocalService localService;
    private final LocalMessageReader localMessageReader;

    public CreateTaxeAnnuelProcessImpl(TaxeSejourAnnuelInfra taxeSejourAnnuelInfra, LocalService localService, LocalMessageReader localMessageReader) {
        this.taxeSejourAnnuelInfra = taxeSejourAnnuelInfra;
        this.localService = localService;
        this.localMessageReader = localMessageReader;
    }

    @Override
    public void validate(CreateTaxeAnnuelInput createTaxeAnnuelInput, Result result) {
        if (taxeSejourAnnuelInfra.existsByRef(createTaxeAnnuelInput.getRef())) {
            result.addErrorMessage(localMessageReader.getMessage("taxe.annuel.notFound"));
        }
        if (taxeSejourAnnuelInfra.findByAnnee(createTaxeAnnuelInput.getAnnee()) != null) {
            result.addErrorMessage(localMessageReader.getMessage("taxe.annuel.alreadyEsiste"));
        }
        if (!localService.existByRef(createTaxeAnnuelInput.getRefLocal())) {
            result.addErrorMessage(localMessageReader.getMessage("local.notFound"));
        }
    }

    @Override
    public void run(CreateTaxeAnnuelInput createTaxeAnnuelInput, Result result) {
        TaxeSejourAnnuelePojo taxeSejourAnnuelePojo = new TaxeSejourAnnuelePojo();

        taxeSejourAnnuelePojo.setAnnee(createTaxeAnnuelInput.getAnnee());
        taxeSejourAnnuelePojo.setNombreNuit(createTaxeAnnuelInput.getNombreNuit());
        taxeSejourAnnuelePojo.setDatePresentation(new Date());
        taxeSejourAnnuelePojo.setRef(createTaxeAnnuelInput.getRef());

        taxeSejourAnnuelInfra.save(taxeSejourAnnuelePojo);
        result.addInfoMessage(localMessageReader.getMessage("taxe.annuel.create"), 201);
    }
}
