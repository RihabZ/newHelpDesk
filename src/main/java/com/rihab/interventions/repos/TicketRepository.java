package com.rihab.interventions.repos;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rihab.interventions.dto.UserDTO;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Intervention;
import com.rihab.interventions.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {

	List<Ticket> findByInterDesignation(String desing);
	 List<Ticket> findByInterDesignationContains(String desing); 
	 
	 
	 
	 List<Ticket> findByEquipementEqptCode(String eqtyCode);
	 List<Ticket>findByInterventionNatureCode(long code);
	// Ticket findByInterCode(String interCode) ;
	List<Ticket> findByTechnicienCodeTechnicien(long codeTechnicien);
	List<Ticket> findByDemandeurCodeDemandeur(long codeDemandeur);
	Long countByInterStatut(String string);
	Collection<UserDTO> findByDatePrevueAfter(Date currentDate);
	Optional<Ticket> findByInterCode(String interCode);
	List<Ticket> findByDatePrevueGreaterThanEqualAndDatePrevueLessThanEqual(Date startDate, Date endDate);
	 
	 
	 
	 
	 
	 
	 
	 
	 
}