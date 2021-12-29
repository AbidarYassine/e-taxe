package com.irisi.local.rest.dto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuartierDto implements Serializable{

	 Long id;
     String nom;
     String numero;
     List<RueDto> rues;
     AnnexAdministrativeDto annexAdministrative;

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

    public List<RueDto> getRues() {
        return rues;
    }

    public void setRues(List<RueDto> rues) {
        this.rues = rues;
    }

    public AnnexAdministrativeDto getAnnexAdministrative() {
        return annexAdministrative;
    }

    public void setAnnexAdministrative(AnnexAdministrativeDto annexAdministrative) {
        this.annexAdministrative = annexAdministrative;
    }
}
