package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Table;

public interface TableRepo extends JpaRepository<Table, Long>{

}
