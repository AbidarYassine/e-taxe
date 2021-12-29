package com.fstg.taxesejour.domaine.process.taxeSejourAnnuel.create;

import com.fstg.taxesejour.domaine.core.AbstractProcessInput;

import java.math.BigDecimal;


public class CreateTaxeAnnuelInput extends AbstractProcessInput {
    private String ref;
    private int annee;
    private BigDecimal nombreNuit;
    private String refLocal;

    @Override
    public String toString() {
        return "CreateTaxeAnnuelInput{" +
                "ref='" + ref + '\'' +
                ", annee=" + annee +
                ", nombreNuit=" + nombreNuit +
                ", refLocal='" + refLocal + '\'' +
                '}';
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public BigDecimal getNombreNuit() {
        return nombreNuit;
    }

    public void setNombreNuit(BigDecimal nombreNuit) {
        this.nombreNuit = nombreNuit;
    }

    public String getRefLocal() {
        return refLocal;
    }

    public void setRefLocal(String refLocal) {
        this.refLocal = refLocal;
    }

}
