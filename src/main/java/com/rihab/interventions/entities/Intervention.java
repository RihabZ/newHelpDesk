package com.rihab.interventions.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Intervention {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	private long idIntervention;

	    @Column(name = "INTE_DT_CLOTURE")
	    private Date dateCloture;

	    @Column(name = "INTE_DESCRIPTION_PANNE")
	    private String descriptionPanne;
	    
	    @Column(name = "INTE_DT_REALISATION")
	    private Date dtRealisation;

	   
	    @Column(name = "INTE_DUREE_REALISATION")
	    private Long dureeRealisation;

	    @Column(name = "INTE_COMPTE_RENDU", length = 4000)
	    private String compteRendu;
	    
	    @Column(name = "INTE_OBSERVATION",  columnDefinition = "VARCHAR(30)")
	    private String interventionObservation;
	    
	   
	    private double interMtHebergement;
	    private double interMtDeplacement;
	    
	    private Long difficulté;
	 
	    
	    @OneToOne
	    private Ticket ticket;
	    
	    @ManyToOne
	    private InterventionType interventionType;
	    
	  
	    @ManyToOne
	    private Cause cause;
	   
}