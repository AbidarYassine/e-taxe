package com.fstg.taxesejour.domaine.process.tauxTaxe.create;

import com.fstg.taxesejour.domaine.core.AbstractProcessImpl;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import com.fstg.taxesejour.infrastructure.messaging.LocalMessageReader;
import com.fstg.taxesejour.utils.Utils;

public class CreateTauxTaxeProcessImpl extends AbstractProcessImpl<CreateTauxTaxeInput> implements CreateTauxTaxeProcess {

    private final TauxTaxeSejourInfra tauxTaxeSejourInfra;
    private final LocalMessageReader localMessageReader;
    private final String BASE_MESSAGE = "create.tauxTaxe.process.impl.";

    public CreateTauxTaxeProcessImpl(TauxTaxeSejourInfra tauxTaxeSejourInfra, LocalMessageReader localMessageReader) {
        this.tauxTaxeSejourInfra = tauxTaxeSejourInfra;
        this.localMessageReader = localMessageReader;
    }

    @Override
    public void validate(CreateTauxTaxeInput abstractProcessInput, Result result) {
        if (abstractProcessInput.ref() == null || abstractProcessInput.ref().isEmpty() || abstractProcessInput.ref().isBlank()) {
            result.addErrorMessage(localMessageReader.getMessage(BASE_MESSAGE + "ref_null"));
        }
        if (tauxTaxeSejourInfra.findByRef(abstractProcessInput.ref()) != null) {
            result.addErrorMessage(localMessageReader.getMessage(BASE_MESSAGE + "exist"));
        }
        if (abstractProcessInput.taux() == null) {
            result.addErrorMessage(localMessageReader.getMessage(BASE_MESSAGE + "taux_null"));
        }
        // TODO VALIDATION DATE
    }

    @Override
    public void run(CreateTauxTaxeInput abstractProcessInput, Result result) {
        TauxTaxeSejour tauxTaxeSejour = new TauxTaxeSejour();
        getObject(tauxTaxeSejour, abstractProcessInput);
        tauxTaxeSejourInfra.save(tauxTaxeSejour);
        result.addInfoMessage(localMessageReader.getMessage(BASE_MESSAGE + "done"), 201);

    }


    private void getObject(TauxTaxeSejour tauxTaxeSejour, CreateTauxTaxeInput abstractProcessInput) {
        tauxTaxeSejour.setRef(abstractProcessInput.ref());
        tauxTaxeSejour.setTaux(abstractProcessInput.taux());
        tauxTaxeSejour.setDateMinApplication(Utils.stringToDate(abstractProcessInput.dateMaxApplication()));
        tauxTaxeSejour.setDateMaxApplication(Utils.stringToDate(abstractProcessInput.dateMaxApplication()));

    }
}
