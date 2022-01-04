package com.irisi.local.rest.dto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommuneDto {
    Long id;
    String nom;
    List<SecteurDto> secteurs;
    String  refVille;
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

    public List<SecteurDto> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<SecteurDto> secteurs) {
        this.secteurs = secteurs;
    }

    public String getRefVille() {
        return refVille;
    }

    public void setRefVille(String refVille) {
        this.refVille = refVille;
    }
}
