package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="balises")
public class Balise {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy="balise")
	List<Critere> criteres = new ArrayList<>();
	
	@Column(name = "balise_nom")
	private String nom;
	
	private int occurence;
	
	@ManyToMany(mappedBy="balises")
	private List<Service> services;
	
	public Champ getChamp() {
		return champ;
	}
	public void setChamp(Champ champ) {
		this.champ = champ;
	}

	private boolean calculated;
	
	@ManyToOne
	@JoinColumn(name="champ_id")
	private Champ champ;
	
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
	public int getOccurence() {
		return occurence;
	}
	public void setOccurence(int occurence) {
		this.occurence = occurence;
	}
	public boolean isCalculated() {
		return calculated;
	}
	public void setCalculated(boolean calculated) {
		this.calculated = calculated;
	}
	
	public Balise(String nom, int occurence, boolean calculated) {
		this.nom = nom;
		this.occurence = occurence;
		this.calculated = calculated;
	}
	
	public Balise() {
	}
	public List<Critere> getCriteres() {
		return criteres;
	}
	public void setCriteres(List<Critere> criteres) {
		this.criteres = criteres;
	}
}
