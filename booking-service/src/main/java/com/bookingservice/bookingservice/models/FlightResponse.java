package com.bookingservice.bookingservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponse {
    private Long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private Integer availableSeats;
}