package com.rihab.interventions.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor 
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class Client {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long codeClient;


    private String nomSociete;
    private String adresse;
    private String ville;
    private long codePostal;
    private String tel;
    
    private String emailSociete;
    private Date dateEntree;
    

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Demandeur> demandeurs;


  
	

    
    /*
@JsonIgnore
@OneToMany(mappedBy = "client")
private List<Ticket> Tickets;
*/

    
}