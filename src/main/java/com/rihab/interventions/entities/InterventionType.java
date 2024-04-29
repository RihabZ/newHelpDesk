package com.rihab.interventions.entities;

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

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INTERVENTION_TYPE", schema = "GPPM")
public class InterventionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codeType;

    @Column(name = "INTT_LIBELLE", length = 30, nullable = false)
    private String libelleType;

    @Column(name = "INTT_BUDG_NUMERO_MODELE", length = 10)
    private String budgetNumeroModele;

    @Column(name = "INTT_DVCL_NUMERO_MODELE", length = 10)
    private String dvclNumeroModele;

    @Column(name = "INTT_ORFA_NUMERO_MODELE")
    private Integer orfaNumeroModele;

    @Column(name = "INTT_DUREE")
    private Integer duree;

    @Column(name = "INTT_UNIT_CODE_DUREE", length = 10)
    private String unitCodeDuree;

    @Column(name = "INTT_DESCRIPTION", length = 4000)
    private String description;

    @Column(name = "INTT_ARTI_CODE", length = 16)
    private String artiCode;

    @Column(name = "DT_CRE")
    private Date dateCreation;

    @Column(name = "LOGIN_CRE", length = 30)
    private String loginCreation;

    @Column(name = "DT_MAJ")
    private Date dateMiseAJour;

    @Column(name = "LOGIN_MAJ", length = 30)
    private String loginMiseAJour;

    @Column(name = "INTT_TYTA_CODE", length = 10)
    private String tytaCode;

    @JsonIgnore
    @OneToMany(mappedBy = "interventionType")
    private List<Intervention> interventions;
}