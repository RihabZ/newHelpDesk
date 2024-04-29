package com.rihab.interventions.entities;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rihab.interventions.entities.Demandeur;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ticket {
	/*
    @Id
    
    @Column(columnDefinition = "BINARY(8)")
	private UUID interCode = UUID.randomUUID();
    
    */
    
    
    @Id
    @Column(length = 10)
    private String interCode;

    @PrePersist //pour générer la valeur de la clé avant la persistance de l'entité
    public void generateInterCode() {
        this.interCode = "I24-" + generateShortUUID();
    }
    private String generateShortUUID() {
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder uuid = new StringBuilder();
        
        for (int i = 0; i < 4; i++) { // Générer une chaîne de 6 caractères alphanumériques aléatoires
            uuid.append(characters.charAt(random.nextInt(characters.length())));
        }
        
        return uuid.toString();
    }



    private long idInter;
    
    
    
     @Column(name = "INTE_DESIGNATION", columnDefinition = "VARCHAR(50)", nullable = false)
    private String interDesignation;

   


    @Column(name = "INTE_DT_CREATION", nullable = false)
    private Date dateCreation;


    @Column(name = "INTE_DESCRIPTION")
    private String description;

    @Column(name = "INTE_DATE_PREVUE")
    private Date datePrevue;

   
    
    @Column(name = "INTE_SOUS_GARANTIE", columnDefinition = "VARCHAR(1) DEFAULT 'N'", nullable = false)
    private String sousGarantie;

    @Column(name = "INTE_SOUS_CONTRAT", columnDefinition = "VARCHAR(1) DEFAULT 'N'", nullable = false)
    private String sousContrat;


    @Column(name = "INTE_PRIORITE", columnDefinition = "VARCHAR(10)")
    private String interPriorite;

    @Column(name = "INTE_DATE_ARRET")
    private Date dateArret;

   
    @Column(name = "INTE_MACHINE_ARRET", columnDefinition = "VARCHAR(3) DEFAULT 'Non'", nullable = false)
    private String machineArret;

    @Column(name = "INTE_DUREE_ARRET")
    private Long dureeArret;

   
   @Column(name="INTE_INTS_CODE", columnDefinition = "VARCHAR(10)", nullable = false)
   private String interStatut;
   
   
   
    @ManyToOne
    private Equipement equipement;

    @ManyToOne
    private InterventionNature interventionNature;

    

@ManyToOne
private Demandeur demandeur;



@ManyToOne
private Technicien technicien;


}