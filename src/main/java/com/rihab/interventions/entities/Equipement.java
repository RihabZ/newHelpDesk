package com.rihab.interventions.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipement {
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "EQPT_CODE",columnDefinition = "VARCHAR(20) ", nullable = false)
private String eqptCode;
@Column(name = "EQPT_DESIGNATION",columnDefinition = "VARCHAR(50)", nullable = false)
private String eqptDesignation;
@Column(name = "EQPT_IDENTIFIANT",columnDefinition = "VARCHAR(50)" )
private String eqptId;

private double eqptPrix;
@Column(name = "EQPT_DT_ACHAT")
private Date eqptDtAchat;
@Column(name = "EQPT_GARANTIE",nullable = false, columnDefinition = "VARCHAR(1) DEFAULT 'O'")
private String eqptGarantie;

@Column(name = "EQPT_CRITIQUE",columnDefinition = "VARCHAR(1) DEFAULT 'N'")
private String eqptCritique;

@Column(name = "EQPT_LOCALISATION",columnDefinition = "VARCHAR(200)")
private String eqptLocalisation;

@Column(name = "EQPT_EN_SERVICE", nullable = false,columnDefinition = "VARCHAR(1) DEFAULT 'O'")
private String eqptEnService;

@Column(name = "EQPT_GAR_TYPE_DT_REF", nullable = false)
private String eqptGarTypeDtRef;


@Column(name = "EQPT_USER_CB1",columnDefinition = "VARCHAR(1)DEFAULT '0'"  )
private String eqptUserCB1; 


@Column(name ="EQPT_MACHINE" ,columnDefinition = "VARCHAR(1) DEFAULT 'N'" , nullable = false) 
private String eqptMachine;

private Date eqptDtCreation;

@Column(name ="LOGIN_CRE" ,columnDefinition ="VARCHAR(20)")
private String eqptLoginCreation;

private Date eqptDtMaj;

@Column(name ="LOGIN_MAJ" ,columnDefinition ="VARCHAR(30)")
private String eqptLoginMaj;



private double eqptDureeGarantie;

@Column(name = "EQPT_DT_FIN_GARANTIE")
private Date dateFinGarantie;

@Column(name = "EQPT_SITE_CODE",columnDefinition ="VARCHAR(10)")
private String siteCode;

@Column(name = "EQPT_CENT_CODE",columnDefinition ="VARCHAR(10)")
private String centreCode;


@Column(name = "EQPT_ARTI_CODE",columnDefinition ="VARCHAR(16)")
private String articleCode;
@Column(name = "eqpt_lot_numero", columnDefinition = "VARCHAR(20)")
private String eqptLotNumero;

@Column(name = "EQPT_NUMERO_SERIE", columnDefinition = "VARCHAR(20)")
private String eqptNumeroSerie;

@Column(name = "EQPT_DT_FABRICATION")
private Date dateFabrication;

@Column(name = "EQPT_DT_INSTALLATION")
private Date dateInstallation;

@Column(name = "EQPT_DT_MISE_EN_SERVICE")
private Date dateMiseEnService;

@Column(name = "EQPT_POST_CODE",columnDefinition ="VARCHAR(10)")
private String postCode;

@Column(name = "EQPT_RESS_CODE",columnDefinition ="VARCHAR(10)")
private String ressCode;

@Column(name = "EQPT_DT_DEMONTAGE")
private Date dateDemontage;

@Column(name = "EQPT_DT_REMPLACEMENT")
private Date dateRemplacement;

@Column(name = "EQPT_DT_LIVRAISON")
private Date dateLivraison;



@ManyToOne
private Type type;

@JsonIgnore
@OneToMany(mappedBy = "equipement")
private List<Ticket> Tickets;



@ManyToOne
private Famille famille;












}
