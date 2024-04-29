package com.rihab.interventions.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codeTechnicien")
@Entity
public class Technicien {
	
	 @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private long codeTechnicien;
	 @Column(name = "PERS_CIVILITE  ",nullable = false, columnDefinition = "VARCHAR(4) DEFAULT 'Mr'")
	 	private String civilite;
	 @Column( name="PERS_RESPONSABLE",nullable = false, columnDefinition = "VARCHAR(1) DEFAULT 'N'")
	 private String responsable ;
	 
	 @Column(name = "PERS_MATRICULE", length = 5)
	    private String matricule;
	    
	 @Column(name = "PERS_INTERNET", length = 50)
	    private String internet;
	    
	 
	 @Column(name = "PERS_NUMERO_ABREGE", length = 10)
	    private String numeroAbrege;
	    
	 

@OneToOne
private User user;


@ManyToOne
private Departement departement;

@JsonIgnore
@OneToMany(mappedBy = "technicien")
private List<Ticket> tickets;


		
}
