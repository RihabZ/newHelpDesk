package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.interventions.entities.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
	

	 
	 List<Technicien> findByDepartementCodeDepart(long codeDepart);

	Technicien findByUserUsername(String username);
}