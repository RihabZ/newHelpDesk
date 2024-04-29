package com.rihab.interventions.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.interventions.entities.Client;

public interface ClientRepository extends JpaRepository<Client, String> {
	

}
