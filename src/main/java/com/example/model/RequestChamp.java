package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="request_champs")
public class RequestChamp {

	@Id
	@GeneratedValue
	private Long id;
	
	private String champ;
	private String tab;
	private boolean memeTable;
	private boolean isNom;
	private String ctab;
	private String cle;
	private boolean response;
	
	private String balise;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="service_id")
	private Service service;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private List<RequestChamp> dependances = new ArrayList<>();
	
	@Transient
	private RequestChamp parent;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChamp() {
		return champ;
	}

	public void setChamp(String champ) {
		this.champ = champ;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public boolean isMemeTable() {
		return memeTable;
	}

	public void setMemeTable(boolean memeTable) {
		this.memeTable = memeTable;
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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<RequestChamp> getDependances() {
		return dependances;
	}

	public void setDependances(List<RequestChamp> dependances) {
		this.dependances = dependances;
	}

	public RequestChamp getParent() {
		return parent;
	}

	public void setParent(RequestChamp parent) {
		this.parent = parent;
	}

	public String getBalise() {
		return balise;
	}

	public void setBalise(String balise) {
		this.balise = balise;
	}

	public String getCle() {
		return cle;
	}

	public void setCle(String cle) {
		this.cle = cle;
	}

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

}
