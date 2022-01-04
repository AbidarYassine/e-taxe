package com.irisi.local.rest.dto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class VilleDto {

    Long id;
    String nom;
    List<CommuneDto> communes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public List<CommuneDto> getCommunes() {
        return communes;
    }

    public void setCommunes(List<CommuneDto> communes) {
        this.communes = communes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
