package com.bookingservice.bookingservice.controllers;

import com.bookingservice.bookingservice.models.Booking;
import com.bookingservice.bookingservice.services.BookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = this.bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = this.bookingService.getBookingById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Booking> createBooking(
            @RequestParam Long customerId,
            @RequestParam Long flightId) {
        Booking booking = this.bookingService.createBooking(customerId, flightId);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}