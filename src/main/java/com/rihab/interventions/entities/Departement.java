package com.rihab.interventions.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Entity
public class Departement {

	 @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private long codeDepart;
	 private String nomDepart;
	 
	 

@JsonIgnore
@OneToMany(mappedBy = "departement")
private List<Technicien> techniciens;


}
