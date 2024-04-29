package com.rihab.interventions.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "eqptDesignation", types = { Equipement.class })
public interface EquipementProjection {

	public String getEqptDesignation();

}
