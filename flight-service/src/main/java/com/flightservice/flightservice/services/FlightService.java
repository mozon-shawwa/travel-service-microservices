package com.flightservice.flightservice.services;

import com.flightservice.flightservice.models.Flight;
import com.flightservice.flightservice.repositories.FlightRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // جلب كل الرحلات
    public List<Flight> getAllFlights(){
        return this.flightRepository.findAll();
    }

    // جلب رحلة واحدة حسب الـ ID
    public Flight getFlightById(Long id){
        return this.flightRepository.findById(id).get();
    }

    // إضافة رحلة جديدة
    public Flight addFlight(Flight flight){
        return this.flightRepository.save(flight);
    }
}