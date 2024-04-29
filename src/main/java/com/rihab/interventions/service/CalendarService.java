package com.rihab.interventions.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rihab.interventions.dto.TicketDTO;
import com.rihab.interventions.entities.CalendarEvent;
import com.rihab.interventions.entities.Ticket;
@Service
public class CalendarService {
	
	private CalendarEvent toCalendarEvent(Ticket ticket) {
	    // Convertir java.util.Date en Timestamp
	    Timestamp datePrevueTimestamp = new Timestamp(ticket.getDatePrevue().getTime());

	    // Créer un nouvel objet CalendarEvent avec la date prévue convertie en Timestamp
	    return new CalendarEvent(ticket.getInterCode(), ticket.getInterDesignation(), ticket.getDemandeur().getUser().getNom() + " " + ticket.getDemandeur().getUser().getPrenom(), datePrevueTimestamp);
	}


    public void addNewTicketsToCalendar(List<Ticket> newTickets) {
        newTickets.forEach(ticket -> {
            CalendarEvent event = toCalendarEvent(ticket);
            // Add the event to your calendar system (e.g., Google Calendar API, etc.)
        });
    }

}
