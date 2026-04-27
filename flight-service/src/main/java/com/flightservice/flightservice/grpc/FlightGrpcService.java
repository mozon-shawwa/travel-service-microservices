package com.flightservice.flightservice.grpc;

import com.flightservice.flightservice.models.Flight;
import com.flightservice.flightservice.services.FlightService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
public class FlightGrpcService extends FlightGrpcServiceGrpc.FlightGrpcServiceImplBase {

    @Autowired
    private FlightService flightService;

    @Override
    public void getFlightById(FlightProto.FlightRequest request,
                              StreamObserver<FlightProto.FlightResponse> responseObserver) {

        Flight flight = flightService.getFlightById(request.getId());

        FlightProto.FlightResponse response = FlightProto.FlightResponse.newBuilder()
                .setId(flight.getId())
                .setFlightNumber(flight.getFlightNumber())
                .setOrigin(flight.getOrigin())
                .setDestination(flight.getDestination())
                .setAvailableSeats(flight.getAvailableSeats())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllFlights(FlightProto.EmptyRequest request,
                              StreamObserver<FlightProto.FlightListResponse> responseObserver) {

        List<Flight> flights = flightService.getAllFlights();

        FlightProto.FlightListResponse.Builder responseBuilder =
                FlightProto.FlightListResponse.newBuilder();

        for (Flight flight : flights) {
            FlightProto.FlightResponse flightResponse = FlightProto.FlightResponse.newBuilder()
                    .setId(flight.getId())
                    .setFlightNumber(flight.getFlightNumber())
                    .setOrigin(flight.getOrigin())
                    .setDestination(flight.getDestination())
                    .setAvailableSeats(flight.getAvailableSeats())
                    .build();
            responseBuilder.addFlights(flightResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}