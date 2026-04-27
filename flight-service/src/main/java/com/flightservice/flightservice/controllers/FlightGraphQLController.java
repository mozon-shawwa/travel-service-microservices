package com.flightservice.flightservice.controllers;

import com.flightservice.flightservice.models.Flight;
import com.flightservice.flightservice.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class FlightGraphQLController {

    @Autowired
    private FlightService flightService;

    @QueryMapping
    public List<Flight> getAllFlights() {
        return this.flightService.getAllFlights();
    }

    @QueryMapping
    public Flight getFlightById(@Argument Long id) {
        return this.flightService.getFlightById(id);
    }
}