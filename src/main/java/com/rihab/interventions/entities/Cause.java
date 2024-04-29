package com.rihab.interventions.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Cause {
 @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long codeCause;


    private String libelle;
    

	@JsonIgnore
	@OneToMany(mappedBy = "cause")
	private List<Intervention> interventions;


}
