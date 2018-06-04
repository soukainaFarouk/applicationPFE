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
@Table(name="services")
public class Service {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "service_nom")
	private String nom;
	
	@Column(name = "service_description")
	private String description;
	
	@Column(name = "service_projet")
	private String projet;
	
	@Column(name = "service_testtma")
	private String testTMA;
	
	@Column(name = "service_complexite")
	private String complexite;
	
	@ManyToOne
	@JoinColumn(name="type_service_id")
	private TypeService typeService;
	
	@ManyToOne
	@JoinColumn(name="filiale_id")
	private Filiale filiale;
	
	@ManyToOne
	@JoinColumn(name="fonction_id")
	private Fonction fonction;
	
	@ManyToMany
	private List<Balise> balises;
	
	@OneToMany(mappedBy="service")
	private List<RequestChamp> requestChamps = new ArrayList<>();
	
	@Column(name = "table_principale")
	private String tablePrincipale;
	
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

	public Service(String nom) {
		this.nom = nom;
	}
	
	public Service() {
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public Filiale getFiliale() {
		return filiale;
	}

	public void setFiliale(Filiale filiale) {
		this.filiale = filiale;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public List<Balise> getBalises() {
		return balises;
	}

	public void setBalises(List<Balise> balises) {
		this.balises = balises;
	}

	public List<RequestChamp> getRequestChamps() {
		return requestChamps;
	}

	public void setRequestChamps(List<RequestChamp> requestChamps) {
		this.requestChamps = requestChamps;
	}

	public String getTablePrincipale() {
		return tablePrincipale;
	}

	public void setTablePrincipale(String tablePrincipale) {
		this.tablePrincipale = tablePrincipale;
	}
	
	
}
