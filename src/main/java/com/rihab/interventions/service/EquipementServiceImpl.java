package com.rihab.interventions.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.dto.EquipementDTO;
import com.rihab.interventions.entities.*;
import com.rihab.interventions.repos.*;

@Service
public class EquipementServiceImpl implements EquipementService {
	
				@Autowired
				EquipementRepository equipementRepository;
	
	
	
	@Override
	public Equipement saveEquipement(Equipement eqpt)
	{
		return equipementRepository.save(eqpt);
		
	}
	
	


@Override
public List<EquipementDTO> getAllEquipementsDTOs() {
    List<Equipement> equipements = equipementRepository.findAll();
    return equipements.stream()
            .map(this::mapToEquipementDTO)
            .collect(Collectors.toList());
}


public EquipementDTO mapToEquipementDTO(Equipement equipement) {
    EquipementDTO dto = new EquipementDTO();
    dto.setCode(equipement.getEqptCode());
    dto.setArticleCode(equipement.getArticleCode());
    dto.setCentreCode(equipement.getCentreCode());
   dto.setDateDemontage(equipement.getDateDemontage());
   dto.setDateFabrication(equipement.getDateFabrication());
   dto.setDateFinGarantie(equipement.getDateFinGarantie());
   dto.setDateInstallation(equipement.getDateInstallation());
   dto.setDateMiseEnService(equipement.getDateMiseEnService());
   dto.setDateRemplacement(equipement.getDateRemplacement());
   dto.setDesignation(equipement.getEqptDesignation());
   dto.setFamille(equipement.getFamille());
   dto.setEqptDtAchat(equipement.getEqptDtAchat());
   dto.setEqptDtCreation(equipement.getEqptDtCreation());
  dto.setDateLivraison(equipement.getDateLivraison());
   dto.setEqptGarantie(equipement.getEqptGarantie());
   dto.setEqptDureeGarantie(equipement.getEqptDureeGarantie());
   dto.setEqptPrix(equipement.getEqptPrix());
   dto.setEqptMachine(equipement.getEqptMachine());
dto.setType(equipement.getType());
dto.setPostCode(equipement.getPostCode());
dto.setRessCode(equipement.getRessCode());
dto.setSiteCode(equipement.getSiteCode());
dto.setEqptEnService(equipement.getEqptEnService());
dto.setEqptId(equipement.getEqptId());
dto.setEqptGarTypeDtRef(equipement.getEqptGarTypeDtRef());
dto.setEqptMachine(equipement.getEqptMachine());
// Map other fields
    return dto;
}


	
	
	
	
	
	
	@Override
	public Equipement updateEquipement(Equipement eqpt) {
			return equipementRepository.save(eqpt);
	}
	
	
	@Override
	public void deleteEquipement(Equipement eqpt) {
		equipementRepository.delete(eqpt);
	}
	
	
	 @Override
	public void deleteEquipementByCode(String code) {
		 equipementRepository.deleteById(code);
	}
	 
	 
	@Override
	public Equipement getEquipement(String code) {
			return equipementRepository.findById(code).get();
	}
	
	
	@Override
	public List<Equipement> getAllEquipements() {
			return equipementRepository.findAll();
	}


	
	@Override
	public List<Equipement> findByEqptDesignation(String desing)
	{
		return equipementRepository.findByEqptDesignation(desing);
	}
	@Override
	public List<Equipement> findByEqptDesignationContains(String desing)
	{
		return equipementRepository.findByEqptDesignationContains(desing);
	}

	@Override
	public List<Equipement> findByDesingPrix ( String desing,Double prix)
	{
		return equipementRepository.findByDesingPrix(desing,prix);
	}


	
	@Override
	public List<Equipement> findByTypeEqtyCode(String eqtyCode)
	{
		return equipementRepository.findByTypeEqtyCode( eqtyCode);
				
	}

	

	
	
	
	
	
	
	
	
}
