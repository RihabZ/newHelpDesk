package com.rihab.interventions.service;


import java.util.List;
import java.util.UUID;
import com.rihab.interventions.dto.TicketDTO;
import com.rihab.interventions.dto.TicketStatisticsDTO;
//import com.rihab.interventions.dto.TicketUpdateDTO;
import com.rihab.interventions.entities.Ticket;

public interface TicketService {
	
	
	TicketDTO saveTicket(TicketDTO inter) ;
	TicketDTO updateTicket(TicketDTO inter);
void deleteTicket(Ticket inter);
 void deleteTicketByCode(String code);
 TicketDTO getTicket(String code);
List<TicketDTO> getAllTickets();

List<Ticket> findByInterDesignation(String desing);
List<Ticket> findByInterDesignationContains(String desing); 


List<Ticket> findByEquipementEqptCode(String eqptCode);
List<Ticket>findByInterventionNatureCode(long code);
//List<Ticket>findByTechnicienCodeTechnicien(long code);

//List<Ticket>findByDemandeurCodeDemandeur(long code);
List<Ticket> findByLoggedInTechnicien();
List<Ticket> findByLoggedInDemandeur();
//List<TicketDTO> getAllTicketDTOs();
//TicketStatisticsDTO getTicketStatistics();
//List<TicketDTO> getPlannedTickets();

Long countTotalTickets();
Long countPendingTickets();
Long countTodoTickets();
Long countDoneTickets();
Long countCancelledTickets();
Long countBlockedTickets();
//TicketDTO updateTicketSelective(String interCode, String interStatut);


//TicketDTO convertEntityToDto (Ticket ticket);

//Ticket convertDtoToEntity(TicketDTO ticketDTO);


}