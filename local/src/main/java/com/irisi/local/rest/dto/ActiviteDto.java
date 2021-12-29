package com.irisi.local.rest.dto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActiviteDto {

    Long id;
    String nom;

    List<LocalDto> locals;

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

    public List<LocalDto> getLocals() {
        return locals;
    }

    public void setLocals(List<LocalDto> locals) {
        this.locals = locals;
    }
}
