package com.fstg.taxesejour.domaine.process.taxeSejourTrim.create;

import com.fstg.taxesejour.domaine.core.AbstractProcessInput;


public class CreateTaxeTrimInput extends AbstractProcessInput {

    String ref;

    String refLocal;

    int numTrim;

    int annee;

    long nombreNuit;

    String refTaxeSejourAnnuel;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefLocal() {
        return refLocal;
    }

    public void setRefLocal(String refLocal) {
        this.refLocal = refLocal;
    }

    public int getNumTrim() {
        return numTrim;
    }

    public void setNumTrim(int numTrim) {
        this.numTrim = numTrim;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public long getNombreNuit() {
        return nombreNuit;
    }

    public void setNombreNuit(long nombreNuit) {
        this.nombreNuit = nombreNuit;
    }

    public String getRefTaxeSejourAnnuel() {
        return refTaxeSejourAnnuel;
    }

    public void setRefTaxeSejourAnnuel(String refTaxeSejourAnnuel) {
        this.refTaxeSejourAnnuel = refTaxeSejourAnnuel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateTaxeTrimInput{");
        sb.append("ref='").append(ref).append('\'');
        sb.append(", refLocal='").append(refLocal).append('\'');
        sb.append(", numTrim=").append(numTrim);
        sb.append(", annee=").append(annee);
        sb.append(", nombreNuit=").append(nombreNuit);
        sb.append(", refTaxeSejourAnnuel='").append(refTaxeSejourAnnuel).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
