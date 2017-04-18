package com.example.jsonendpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by trainer3 on 4/6/17.
 */
@RestController
@RequestMapping("/flights")
public class FlightController {

    /*@GetMapping("/flights/flight")
    public String getFlightDetails(@RequestBody Flight flight){
        return flight.toString();
    }*/
    @GetMapping("/flight")
    public Flight getFlight(){

        Date date = new Date();
        date.toString();
        Flight.Passenger passenger = new Flight.Passenger("Some name","Some other name");
        Flight.Details details = new Flight.Details(passenger, 200);
        Flight flight = new Flight(date, Arrays.asList(details));

       return flight;
    }

    @GetMapping("")
    public List<Flight> getListOfFlights(){
        Date date1 = new Date();
        date1.toString();
        Flight.Passenger passenger1 = new Flight.Passenger("Some name","Some other name");
        Flight.Details details1 = new Flight.Details(passenger1, 200);
        Flight flight1 = new Flight(date1, Arrays.asList(details1));

        Date date2 = new Date();
        date2.toString();
        Flight.Passenger passenger2 = new Flight.Passenger("Some other name",null);
        Flight.Details details2 = new Flight.Details(passenger2, 400);
        Flight flight2 = new Flight(date2, Arrays.asList(details2));

        List<Flight> flightList = new ArrayList();
        flightList.add(flight1);
        flightList.add(flight2);

        return flightList;
    }

}
