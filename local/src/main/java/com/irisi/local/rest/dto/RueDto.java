package com.irisi.local.rest.dto;

import java.io.Serializable;
import java.util.List;

public class RueDto implements Serializable{

	private Long id;
	private String nom;
	private String numero;
	private QuartierDto quartier;
    private List<LocalDto> locals;

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

	public QuartierDto getQuartier() {
		return quartier;
	}

	public void setQuartier(QuartierDto quartier) {
		this.quartier = quartier;
	}

	public List<LocalDto> getLocals() {
		return locals;
	}

	public void setLocals(List<LocalDto> locals) {
		this.locals = locals;
	}
}
