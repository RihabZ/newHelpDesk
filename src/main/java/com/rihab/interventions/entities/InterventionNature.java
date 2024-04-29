package com.rihab.interventions.entities;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INTERVENTION_NATURE")
public class InterventionNature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;

    @Column(name = "INTN_LIBELLE", length = 30)
    private String libelle;

    @Column(name = "INTN_FACT_METHODE", length = 3)
    private String facturationMethode;

    @Column(name = "INTN_FACT_REEL_FRAIS", length = 1, nullable = false)
    private String facturationReelleFrais;

    @Column(name = "INTN_FACT_REEL_MO", length = 1, nullable = false)
    private String facturationReelleMO;

    @Column(name = "INTN_FACT_REEL_PIECES", length = 1, nullable = false)
    private String facturationReellePieces;

    @Column(name = "INTN_INGC_CODE", length = 10)
    private String ingcCode;

    @Column(name = "DT_CRE")
    private Date dateCreation;

    @Column(name = "LOGIN_CRE", length = 30)
    private String loginCreation;

    @Column(name = "DT_MAJ")
    private Date dateMiseAJour;

    @Column(name = "LOGIN_MAJ", length = 30)
    private String loginMiseAJour;

    @JsonIgnore
    @OneToMany(mappedBy = "interventionNature")
    private List<Ticket> tickets;
}
