package com.example.jsonendpoints;

import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by trainer3 on 4/7/17.
 */
@RestController
public class TicketsTotalController {

    /*private String result;

    public TicketsTotalController(String result){
        this.result = result;
    }*/

    @RequestMapping(value = "/flights/tickets/total", method = {RequestMethod.POST},
            consumes = "application/json", produces = "application/json")
    public @ResponseBody Result getJSONData(@RequestBody FlightTicket flightTicket) {
        Integer price = 0;
        Result result = new Result();

        List<Details> listTickets = flightTicket.getTickets();
        for(Details val : listTickets ){
            price += val.getPrice();
        }
            result.setResult(price);
            return result;

    }

}
