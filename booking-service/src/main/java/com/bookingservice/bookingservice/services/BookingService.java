package com.bookingservice.bookingservice.services;

import com.bookingservice.bookingservice.models.Booking;
import com.bookingservice.bookingservice.models.FlightResponse;
import com.bookingservice.bookingservice.repositories.BookingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String FLIGHT_SERVICE_URL = "http://localhost:9001/flights/";

    // جلب كل الحجوزات
    public List<Booking> getAllBookings() {
        return this.bookingRepository.findAll();
    }

    // جلب حجز واحد حسب الـ ID
    public Booking getBookingById(Long id) {
        return this.bookingRepository.findById(id).get();
    }

    // إنشاء حجز جديد مع التحقق من توفر الرحلة
    public Booking createBooking(Long customerId, Long flightId) {
        FlightResponse flight = restTemplate.getForObject(
                FLIGHT_SERVICE_URL + flightId,
                FlightResponse.class
        );

        if (flight == null || flight.getAvailableSeats() <= 0) {
            throw new RuntimeException("No available seats for this flight");
        }

        Booking booking = new Booking(null, customerId, flightId, "CONFIRMED");
        return this.bookingRepository.save(booking);
    }
}