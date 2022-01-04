package com.irisi.local.rest.dto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class SecteurDto {


    Long id;
    String nom;
    List<AnnexAdministrativeDto> annexAdministratives ;
    List<ZoneDto> zones;
    CommuneDto commune;

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

    public List<AnnexAdministrativeDto> getAnnexAdministratives() {
        return annexAdministratives;
    }

    public void setAnnexAdministratives(List<AnnexAdministrativeDto> annexAdministratives) {
        this.annexAdministratives = annexAdministratives;
    }

    public List<ZoneDto> getZones() {
        return zones;
    }

    public void setZones(List<ZoneDto> zones) {
        this.zones = zones;
    }

    public CommuneDto getCommune() {
        return commune;
    }

    public void setCommune(CommuneDto commune) {
        this.commune = commune;
    }
}
