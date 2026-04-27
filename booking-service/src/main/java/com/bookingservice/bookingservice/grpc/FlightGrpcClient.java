package com.bookingservice.bookingservice.grpc;

import com.flightservice.flightservice.grpc.FlightGrpcServiceGrpc;
import com.flightservice.flightservice.grpc.FlightProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class FlightGrpcClient {

    @GrpcClient("flight-service")
    private FlightGrpcServiceGrpc.FlightGrpcServiceBlockingStub flightStub;

    public FlightProto.FlightResponse getFlightById(Long id) {
        FlightProto.FlightRequest request = FlightProto.FlightRequest.newBuilder()
                .setId(id)
                .build();
        return flightStub.getFlightById(request);
    }

    public FlightProto.FlightListResponse getAllFlights() {
        FlightProto.EmptyRequest request = FlightProto.EmptyRequest.newBuilder()
                .build();
        return flightStub.getAllFlights(request);
    }
}