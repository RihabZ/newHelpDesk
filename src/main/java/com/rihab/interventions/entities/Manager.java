package com.rihab.interventions.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codeManager")
@Entity
public class Manager {
	
	 @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private long codeManager;
	 @Column(name = "PERS_CIVILITE  ",nullable = false, columnDefinition = "VARCHAR(4) DEFAULT 'Mr'")
	 	private String civilite;
	 

@OneToOne
private User user;



}
