package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Domaine;

public interface DomaineRepo extends JpaRepository<Domaine, Long>{

}
