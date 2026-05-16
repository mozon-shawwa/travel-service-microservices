package com.paymentservice.paymentservice.services;

import com.paymentservice.paymentservice.models.Payment;
import com.paymentservice.paymentservice.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        // محاكاة لعملية الدفع: دائماً نجعلها ناجحة SUCCESS
        payment.setStatus("SUCCESS");
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}