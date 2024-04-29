package com.rihab.interventions.entities;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import com.rihab.interventions.dto.TicketDTO;

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
public class CalendarEvent {
    private String title;
    private String description;
    private Timestamp startDate;

    public CalendarEvent(String interCode, String interDesignation, String nomDemandeur, Timestamp datePrevueTimestamp) {
        this.title = String.format("%s - %s (%s)", interCode, interDesignation, nomDemandeur);
        this.description = interDesignation;
        this.startDate = datePrevueTimestamp;
    }

    // Getters and setters

   
}