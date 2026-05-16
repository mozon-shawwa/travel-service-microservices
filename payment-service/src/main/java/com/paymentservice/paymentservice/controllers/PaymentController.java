package com.paymentservice.paymentservice.controllers;

import com.paymentservice.paymentservice.models.Payment;
import com.paymentservice.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay")
    public Payment makePayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }

    @GetMapping("/all")
    public List<Payment> getAll() {
        return paymentService.getAllPayments();
    }
}