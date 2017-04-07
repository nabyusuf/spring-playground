package com.example.jsonendpoints;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by trainer3 on 4/6/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flight {

    public Date departs;
    public List<Details> tickets;

    public Flight(Date departs, List<Details> tickets) {
        this.departs = departs;
        this.tickets = tickets;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("Departs")
    public Date getDeparts() {
        return departs;
    }

    public void setDeparts(Date departs) {
        this.departs = departs;
    }

    @JsonProperty("Tickets")
    public List<Details> getTickets() {
        return tickets;
    }

    public void setTickets(List<Details> tickets) {
        this.tickets = tickets;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Details{
        public Passenger passenger;
        Integer price;

        public Details(Passenger passenger, Integer price) {
            this.passenger = passenger;
            this.price = price;
        }

        @JsonProperty("Passenger")
        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }

        @JsonProperty("Price")
        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Passenger{
        String firstName;
        String lastName;

        public Passenger(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @JsonProperty("FirstName")
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @JsonProperty("LastName")
        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
