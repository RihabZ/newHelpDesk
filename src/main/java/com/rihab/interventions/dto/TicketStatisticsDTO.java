package com.rihab.interventions.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketStatisticsDTO {
	
	 private Long totalTickets;
	    private Long pendingTickets;
	    private Long todoTickets;
	    private Long doneTickets;
	    private Long cancelledTickets;
	    private Long blockedTickets;
}
