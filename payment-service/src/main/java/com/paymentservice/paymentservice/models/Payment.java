package com.paymentservice.paymentservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookingId; // ربط الدفع برقم الحجز
    private Double amount;
    private String status; // مثلاً: PENDING, SUCCESS, FAILED
}