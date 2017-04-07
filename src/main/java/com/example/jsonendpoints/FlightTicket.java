package com.example.jsonendpoints;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by trainer3 on 4/7/17.
 */
public class FlightTicket {

    private List<Details> tickets;

    public FlightTicket(){}

    public FlightTicket(List<Details> tickets) {
        this.tickets = tickets;
    }

    @JsonProperty("tickets")
    public List<Details> getTickets() {
        return tickets;
    }

    @JsonProperty("tickets")
    public void setTickets(List<Details> tickets) {
        this.tickets = tickets;
    }
}