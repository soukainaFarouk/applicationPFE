package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@javax.persistence.Table(name="champs")
public class Champ {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "champ_nom")
	private String nom;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "table_id")
	private com.example.model.Table table;
	
	@OneToMany(mappedBy="champ")
	private List<Balise> balises = new ArrayList<>();
	
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

	public Champ(String nom) {
		this.nom = nom;
	}
	
	public Champ() {
	}

	public com.example.model.Table getTable() {
		return table;
	}

	public void setTable(com.example.model.Table table) {
		this.table = table;
	}

	public List<Balise> getBalises() {
		return balises;
	}

	public void setBalises(List<Balise> balises) {
		this.balises = balises;
	}
}