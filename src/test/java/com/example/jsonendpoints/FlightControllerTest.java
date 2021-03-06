package com.example.jsonendpoints;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer3 on 4/6/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testFlightRequest() throws Exception {
        MockHttpServletRequestBuilder request = get("/flights/flight")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"Departs\":\"2017-05-02 18:56\",\"Tickets\":[{\"Passenger\":{\"FirstName\":\"Some name\",\"LastName\":\"Some other name\"},\"Price\":200}]}"));
    }

    @Test
    public void testGetForFlightWithJson() throws Exception {
        this.mvc.perform(get("/flights/flight")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", is("Some name")))
                .andExpect(jsonPath("$.Tickets[0].Passenger.LastName", is("Some other name")))
                .andExpect(jsonPath("$.Tickets[0].Price", is(200)));
    }

    @Test
    public void testGetForFlightListWithJson() throws Exception {
       // String json = getJSON("/data.json");

        this.mvc.perform(get("/flights/flight")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", is("Some name")))
                .andExpect(jsonPath("$.Tickets[0].Passenger.LastName", is("Some other name")))
                .andExpect(jsonPath("$.Tickets[0].Price", is(200)))
                .andExpect(jsonPath("$.Tickets[1].Passenger.FirstName", is("Some other name")))
                .andExpect(jsonPath("$.Tickets[1].Passenger.LastName", isEmptyOrNullString()))
                .andExpect(jsonPath("$.Tickets[1].Price", is(400)));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}

