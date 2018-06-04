package com.example.dataModel;

public class HomeChart {

	private String service;
	private String date;
	private String chargeTravail;
	private String collaborateur;
	
	public HomeChart() {
		super();
	}
	public HomeChart(String service, String date, String chargeTravail, String collaborateur) {
		super();
		this.service = service;
		this.date = date;
		this.chargeTravail = chargeTravail;
		this.collaborateur = collaborateur;
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
