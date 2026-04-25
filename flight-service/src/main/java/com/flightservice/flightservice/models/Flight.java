package com.flightservice.flightservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String flightNumber; // رقم الرحلة (مثلاً FL123)
    private String origin;       // من وين (مثلاً Gaza)
    private String destination;  // لوين (مثلاً Dubai)
    private Integer availableSeats; // المقاعد المتاحة
}