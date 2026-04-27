package com.bookingservice.bookingservice.services;

import com.bookingservice.bookingservice.grpc.FlightGrpcClient;
import com.bookingservice.bookingservice.models.Booking;
import com.bookingservice.bookingservice.repositories.BookingRepository;
import com.flightservice.flightservice.grpc.FlightProto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightGrpcClient flightGrpcClient;

    // جلب كل الحجوزات
    public List<Booking> getAllBookings() {
        return this.bookingRepository.findAll();
    }

    // جلب حجز واحد حسب الـ ID
    public Booking getBookingById(Long id) {
        return this.bookingRepository.findById(id).get();
    }

    // إنشاء حجز جديد عبر gRPC
    public Booking createBooking(Long customerId, Long flightId) {

        // التحقق من توفر الرحلة عبر gRPC
        FlightProto.FlightResponse flight = flightGrpcClient.getFlightById(flightId);

        if (flight == null || flight.getAvailableSeats() <= 0) {
            throw new RuntimeException("No available seats for this flight");
        }

        Booking booking = new Booking(null, customerId, flightId, "CONFIRMED");
        return this.bookingRepository.save(booking);
    }
}