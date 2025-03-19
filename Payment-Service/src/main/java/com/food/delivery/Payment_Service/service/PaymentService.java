package com.food.delivery.Payment_Service.service;

import com.food.delivery.Payment_Service.entity.Payment;
import com.food.delivery.Payment_Service.entity.PaymentStatus;
import com.food.delivery.Payment_Service.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Payment processPayment(Payment payment) {
        payment.setStatus(PaymentStatus.PENDING);
        payment.setCreatedAt(LocalDateTime.now());

        // Simulate a payment gateway response
        boolean isPaymentSuccessful = Math.random() > 0.2;
        payment.setStatus(isPaymentSuccessful ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);

        return paymentRepository.save(payment);
    }

    public Payment getPaymentByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Payment not found for order ID: " + orderId));
    }
}
