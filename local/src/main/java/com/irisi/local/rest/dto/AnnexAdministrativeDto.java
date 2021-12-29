package com.irisi.local.rest.dto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnnexAdministrativeDto implements Serializable {

     Long id;
     String nom;
     String numero;
     List<QuartierDto> quartiers;
     SecteurDto secteur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<QuartierDto> getQuartiers() {
        return quartiers;
    }

    public void setQuartiers(List<QuartierDto> quartiers) {
        this.quartiers = quartiers;
    }

    public SecteurDto getSecteur() {
        return secteur;
    }

    public void setSecteur(SecteurDto secteur) {
        this.secteur = secteur;
    }
}
