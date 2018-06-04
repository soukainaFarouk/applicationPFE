package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="filiales")
public class Filiale {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "filiale_nom")
	private String filiale_nom;
	
	@Column(name = "filiale_pays")
	private String filiale_pays;
	
	@Column(name = "filiale_branche")
	private String filiale_branche;
	
	@Column(name = "filiale_bddtype")
	private String filiale_bddtype;
	
	@Column(name = "nom_bdd")
	private String nom_bdd;
	
	@Column(name = "filiale_ip")
	private String filiale_ip;
	
	@Column(name = "filiale_user")
	private String filiale_user;
	
	@Column(name = "filiale_password")
	private String filiale_password;
	
	@OneToMany(mappedBy="filiale")
	private List<Service> services = new ArrayList<>();
	
	public Filiale() {
		
	}

	public Filiale(Long id, String filiale_nom, String filiale_pays, String filiale_branche, String filiale_bddtype,
			String nom_bdd, String filiale_ip, String filiale_user, String filiale_password, List<Service> services) {
		super();
		this.id = id;
		this.filiale_nom = filiale_nom;
		this.filiale_pays = filiale_pays;
		this.filiale_branche = filiale_branche;
		this.filiale_bddtype = filiale_bddtype;
		this.nom_bdd = nom_bdd;
		this.filiale_ip = filiale_ip;
		this.filiale_user = filiale_user;
		this.filiale_password = filiale_password;
		this.services = services;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFiliale_nom() {
		return filiale_nom;
	}

	public void setFiliale_nom(String filiale_nom) {
		this.filiale_nom = filiale_nom;
	}

	public String getFiliale_pays() {
		return filiale_pays;
	}

	public void setFiliale_pays(String filiale_pays) {
		this.filiale_pays = filiale_pays;
	}

	public String getFiliale_branche() {
		return filiale_branche;
	}

	public void setFiliale_branche(String filiale_branche) {
		this.filiale_branche = filiale_branche;
	}

	public String getFiliale_bddtype() {
		return filiale_bddtype;
	}

	public void setFiliale_bddtype(String filiale_bddtype) {
		this.filiale_bddtype = filiale_bddtype;
	}

	public String getNom_bdd() {
		return nom_bdd;
	}

	public void setNom_bdd(String nom_bdd) {
		this.nom_bdd = nom_bdd;
	}

	public String getFiliale_ip() {
		return filiale_ip;
	}

	public void setFiliale_ip(String filiale_ip) {
		this.filiale_ip = filiale_ip;
	}

	public String getFiliale_user() {
		return filiale_user;
	}

	public void setFiliale_user(String filiale_user) {
		this.filiale_user = filiale_user;
	}

	public String getFiliale_password() {
		return filiale_password;
	}

	public void setFiliale_password(String filiale_password) {
		this.filiale_password = filiale_password;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	
}
