package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.interventions.entities.Departement;


public interface DepartementRepository extends JpaRepository<Departement, Long> {
	

}
