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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Famille {
	@Id
    @Column(name = "EQFA_CODE", nullable = false , columnDefinition = "VARCHAR(20)")
    private String eqfaCode;

    @Column(name = "EQFA_LIBELLE", nullable = false,columnDefinition = "VARCHAR(30)")
   private String eqfaLibelle;

    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CRE")
    private Date dtCre;

    @Column(name = "LOGIN_CRE", length = 30)
    private String loginCre;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_MAJ")
    private Date dtMaj;

    @Column(name = "LOGIN_MAJ", length = 30)
    private String loginMaj;

	
	@JsonIgnore
	@OneToMany(mappedBy = "famille")
	private List<Equipement> equipements;


	

	@Override
	public String toString() {
		return "Famille [eqfaCode=" + eqfaCode + ", eqfaLibelle=" + eqfaLibelle + ", dtCre=" + dtCre + ", loginCre="
				+ loginCre + ", dtMaj=" + dtMaj + ", loginMaj=" + loginMaj + ", equipements=" + equipements + "]";
	}


	
	
}
