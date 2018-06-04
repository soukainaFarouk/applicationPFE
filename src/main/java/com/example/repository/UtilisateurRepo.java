package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Utilisateur;

@Repository("utilisateurRepo")
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long>{
	Utilisateur findByEmail(String email);
}