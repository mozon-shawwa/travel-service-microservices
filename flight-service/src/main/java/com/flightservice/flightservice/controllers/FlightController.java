package com.flightservice.flightservice.controllers;

import com.flightservice.flightservice.models.Flight;
import com.flightservice.flightservice.services.FlightService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights") // حذفنا api عشان نصير زي المهندس بالضبط
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/")
    public ResponseEntity<List<Flight>> showAllFlights() {
        List<Flight> flights = this.flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Flight retrievedFlight = this.flightService.getFlightById(id);
        return new ResponseEntity<>(retrievedFlight, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight newFlight = this.flightService.addFlight(flight);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }
}