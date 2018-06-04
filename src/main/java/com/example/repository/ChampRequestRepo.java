package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.RequestChamp;
import com.example.model.Service;

public interface ChampRequestRepo extends JpaRepository<RequestChamp, Long>{
	
	@Query
	public RequestChamp findByServiceAndBalise(Service service,String balise);
	
	@Query
	public List<RequestChamp> findByResponseAndService(boolean reponse,Service service);
}
