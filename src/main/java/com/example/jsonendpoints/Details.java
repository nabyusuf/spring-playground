package com.example.jsonendpoints;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by trainer3 on 4/7/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Details {

        private Passenger passenger;
        private Integer price;

        public Details() {
        }

        public Details(Passenger passenger, Integer price) {
            this.passenger = passenger;
            this.price = price;
        }

        @JsonProperty("passenger")
        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }

        @JsonProperty("price")
        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }
    }