package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activite")
public class Activite {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "activite_service")
	private String service;
	
	@Column(name = "activite_date")
	private String date;
	
	@Column(name = "activite_charge")
	private String chargeTravail;
	
	@Column(name = "activite_collaborateur")
	private String collaborateur;
	
	public Activite() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getChargeTravail() {
		return chargeTravail;
	}

	public void setChargeTravail(String chargeTravail) {
		this.chargeTravail = chargeTravail;
	}

	public String getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(String collaborateur) {
		this.collaborateur = collaborateur;
	}
	
	
}
