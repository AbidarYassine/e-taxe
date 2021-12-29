package com.irisi.local.rest.dto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocalDto implements Serializable {
    Long id;
    String ref;
    String nom;
    String numeroCaissier;
    String nomCommercial;
    RedevableDto redevable;
    RueDto rue;
    ActiviteDto activite;
    int dernierAnneePayer;
    int dernierTrimPayer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNumeroCaissier() {
        return numeroCaissier;
    }

    public void setNumeroCaissier(String numeroCaissier) {
        this.numeroCaissier = numeroCaissier;
    }

    public String getNomCommercial() {
        return nomCommercial;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public RueDto getRue() {
        return rue;
    }

    public void setRue(RueDto rue) {
        this.rue = rue;
    }

    public ActiviteDto getActivite() {
        return activite;
    }

    public void setActivite(ActiviteDto activite) {
        this.activite = activite;
    }

    public RedevableDto getRedevable() {
        return redevable;
    }

    public void setRedevable(RedevableDto redevable) {
        this.redevable = redevable;
    }

    public int getDernierAnneePayer() {
        return dernierAnneePayer;
    }

    public void setDernierAnneePayer(int dernierAnneePayer) {
        this.dernierAnneePayer = dernierAnneePayer;
    }

    public int getDernierTrimPayer() {
        return dernierTrimPayer;
    }

    public void setDernierTrimPayer(int dernierTrimPayer) {
        this.dernierTrimPayer = dernierTrimPayer;
    }

    @Override
    public String toString() {
        return "LocalDto{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", nom='" + nom + '\'' +
                ", numeroCaissier='" + numeroCaissier + '\'' +
                ", nomCommercial='" + nomCommercial + '\'' +
                ", redevable=" + redevable +
                ", rue=" + rue +
                ", activite=" + activite +
                ", dernierAnneePayer=" + dernierAnneePayer +
                ", dernierTrimPayer=" + dernierTrimPayer +
                '}';
    }
}
