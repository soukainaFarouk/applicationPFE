package com.example.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="domaines")
public class Domaine {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "domaine_nom")
	private String domaine_nom;
	
	@Column(name = "domaine_desc")
	private String description;
	
	@OneToMany(mappedBy="domaine")
	private List<Fonction> fonctions = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomaine_nom() {
		return domaine_nom;
	}

	public void setDomaine_nom(String domaine_nom) {
		this.domaine_nom = domaine_nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String domaine_desc) {
		this.description = domaine_desc;
	}

	public List<Fonction> getFonctions() {
		return fonctions;
	}

	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}

	
	
}
