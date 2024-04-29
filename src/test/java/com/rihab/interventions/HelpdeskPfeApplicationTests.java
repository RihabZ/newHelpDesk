package com.rihab.interventions;

import java.util.List;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Type;
import com.rihab.interventions.repos.EquipementRepository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelpdeskPfeApplicationTests {

	@Autowired
	private EquipementRepository equipementRepository;

	
	@Test
	public void testCreateEquipement() {
	Equipement eqpt = new Equipement("PR-S14","Presse de sertissage","WSC20-255",0, null, "O","N",null, null, null, null, null, new Date(), null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

	 eqpt.setEqptEnService("O");
	 eqpt.setEqptGarTypeDtRef("AUC");
	 eqpt.setEqptMachine("N");
	 eqpt.setEqptUserCB1("O");
	equipementRepository.save(eqpt);
	}

	 @Test
	 public void testFindEquipement()
	 {
		 Optional<Equipement> eqpt = equipementRepository.findById("PR-S14");
	 System.out.println(eqpt);
	 }
		
	
	 @Test
	 public void testUpdateEquipement()
	 {
		 Equipement eqpt = equipementRepository.findById("PR-S14").get();
		 eqpt.setEqptDesignation("sertage");
	 equipementRepository.save(eqpt);
	 }

	
	 @Test
	 public void testDeleteEquipement()
	 {
		 equipementRepository.deleteById("PR-S14");
	 }

	 
	 @Test
	 public void testListerTousEquipements()
	 {
	 List<Equipement> eqps = equipementRepository.findAll();
	 for (Equipement eqpt : eqps)
	 {
	 System.out.println(eqpt);
	 }
	 }

	 
	 @Test
	 public void testFindByEqptDesignation()
	 {
	 List<Equipement> eqpts = equipementRepository.findByEqptDesignation("Presse de sertissage");
		for (Equipement e : eqpts)
			 {
			 System.out.println(e);
			 }
	 }

	 @Test
	 public void testFindByEqptDesignationContains ()
	 {
	 List<Equipement> eqpts=equipementRepository.findByEqptDesignation("Presse");
	 		for (Equipement e : eqpts)
	 {
	 				System.out.println(e);
	 } }


	 
	 
	 @Test
	 public void testfindByDesingPrix()
	 {
		 List<Equipement> eqpts=equipementRepository.findByDesingPrix("Pressde sertissage",2200.0 );
	 		for (Equipement e : eqpts)
	 {
	 				System.out.println(e);
	 } 
	 }
	 
	 @Test
	 public void testfindByType()
	 {
	 Type type = new Type();
	 type.setEqtyCode("PRESS");
	
	 }
	 
	 
	 @Test
	 public void testFindByTypeEqtyCode()
	 {
		 List<Equipement> eqpts=equipementRepository.findByTypeEqtyCode("PRESS");
		 	for (Equipement e : eqpts)
		 {
		 				System.out.println(e);
		 } 
		 }
	 
	 }
	 
	 
	 
	
