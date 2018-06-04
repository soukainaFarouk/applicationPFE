package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="criteres")
public class Critere {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="balise_id")
	private Balise balise;
	
	@ManyToOne
	@JoinColumn(name="critere_id")
	private Balise critere;
	
	private boolean isNom;
	private String ctab;
	
	public Balise getBalise() {
		return balise;
	}
	public void setBalise(Balise balise) {
		this.balise = balise;
	}
	public boolean isNom() {
		return isNom;
	}
	public void setNom(boolean isNom) {
		this.isNom = isNom;
	}
	public String getCtab() {
		return ctab;
	}
	public void setCtab(String ctab) {
		this.ctab = ctab;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Balise getCritere() {
		return critere;
	}
	public void setCritere(Balise critere) {
		this.critere = critere;
	}
	
} 
