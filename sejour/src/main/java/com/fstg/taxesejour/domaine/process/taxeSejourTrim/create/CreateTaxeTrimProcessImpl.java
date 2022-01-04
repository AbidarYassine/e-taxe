package com.fstg.taxesejour.domaine.process.taxeSejourTrim.create;

import com.fstg.taxesejour.domaine.core.AbstractProcessImpl;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.Local;
import com.fstg.taxesejour.domaine.pojo.TauxRetardTaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.pojo.TauxTaxeSejourPojo;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.messaging.LocalMessageReader;
import com.fstg.taxesejour.infrastructure.required.LocalService;
import com.fstg.taxesejour.utils.Utils;

import java.util.Date;

public class CreateTaxeTrimProcessImpl extends AbstractProcessImpl<TaxeSejourTrimPojo> implements CreateTaxeTrimProcess {

    private TauxTaxeSejourPojo tauxTaxeSejour;
    private TauxRetardTaxeSejourTrimPojo tauxRetardTaxeSejourTrim;
    private final TaxeSejourTrimInfra taxeSejourTrimInfra;
    private final TauxTaxeSejourInfra tauxTaxeSejourInfra;
    private final TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra;
    private final LocalService localService;
    private final LocalMessageReader localMessageReader;

    public CreateTaxeTrimProcessImpl(TaxeSejourTrimInfra taxeSejourTrimInfra, TauxTaxeSejourInfra tauxTaxeSejourInfra,
                                     TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra, LocalService localService, LocalMessageReader localMessageReader) {
        this.taxeSejourTrimInfra = taxeSejourTrimInfra;
        this.tauxTaxeSejourInfra = tauxTaxeSejourInfra;
        this.tauxRetardTaxeSejourTrimInfra = tauxRetardTaxeSejourTrimInfra;
        this.localService = localService;
        this.localMessageReader = localMessageReader;
    }

    @Override
    public void validate(TaxeSejourTrimPojo createTaxeTrimInput, Result result) {
        if (!localService.existByRef(createTaxeTrimInput.getRefLocal())) {
            result.addErrorMessage(localMessageReader.getMessage("local.not-found"));
        }
        if (taxeSejourTrimInfra.existeByRef(createTaxeTrimInput.getRef())) {
            result.addErrorMessage(localMessageReader.getMessage("taxe.trim.alreadyEsiste"));
        }
        if (taxeSejourTrimInfra.existsByAnneeAndNumTrim(createTaxeTrimInput.getAnnee(), createTaxeTrimInput.getNumTrim())) {
            result.addErrorMessage(localMessageReader.getMessage("taxe.trim.alreadyEsiste_annee_trim"));
        }
        tauxTaxeSejour = tauxTaxeSejourInfra.getCurrentTauxTaxe(new Date());
        if (tauxTaxeSejour == null) {
            result.addErrorMessage(localMessageReader.getMessage("taux-taxe-retard.trim.notfoud"));
        }
        tauxRetardTaxeSejourTrim = tauxRetardTaxeSejourTrimInfra.getTauxByCurrnetDate(new Date());
        if (tauxRetardTaxeSejourTrim == null) {
            result.addErrorMessage(localMessageReader.getMessage("taux-taxe-retard.trim.notfoud"));
        }
    }

    @Override
    public void run(TaxeSejourTrimPojo taxeSejourTrimPojo, Result result) {
        /* par reference */
        getTaxeSejourTrimPojo(taxeSejourTrimPojo);
        taxeSejourTrimPojo.setTauxTaxeSejour(tauxTaxeSejour);
        taxeSejourTrimPojo.setTauxRetardTaxeSejourTrim(tauxRetardTaxeSejourTrim);
        if (!taxeSejourTrimPojo.isSimulation()) taxeSejourTrimInfra.save(taxeSejourTrimPojo);
        taxeSejourTrimPojo.setDatePresentation(new Date());
        result.addInfoMessage(localMessageReader.getMessage("taxe-sejour-trim.created"), 201);
        Local local = new Local(taxeSejourTrimPojo.getRefLocal(), taxeSejourTrimPojo.getAnnee(), taxeSejourTrimPojo.getNumTrim());
        if (!taxeSejourTrimPojo.isSimulation()) localService.update(local);
        result.addInfoMessage(localMessageReader.getMessage("local.updated"), 201);
        result.setOutput(taxeSejourTrimPojo);

    }

    private void getTaxeSejourTrimPojo(TaxeSejourTrimPojo taxeSejourTrimPojo) {
        int nombreMoisRetard = Utils.getNumberOfMonthRetard(taxeSejourTrimPojo.getNumTrim(), taxeSejourTrimPojo.getAnnee());
        taxeSejourTrimPojo.setNombreMoisRetard(nombreMoisRetard);
        taxeSejourTrimPojo.setMontant(Utils.getMontant(tauxTaxeSejour.getTaux(), taxeSejourTrimPojo.getNombreNuit()));
        Utils.calculateMontantRetard(
                tauxRetardTaxeSejourTrim.getPremierMoisRetard(),
                taxeSejourTrimPojo,
                tauxRetardTaxeSejourTrim.getAutreMoisRetard(),
                nombreMoisRetard
        );
    }


}
