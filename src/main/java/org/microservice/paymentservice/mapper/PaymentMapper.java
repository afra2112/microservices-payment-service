package org.microservice.paymentservice.mapper;

import jakarta.validation.Valid;
import org.microservice.paymentservice.controller.dto.PaymentRequest;
import org.microservice.paymentservice.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment requestToEntity(@Valid PaymentRequest request) {
        return Payment.builder()
                .paymentId(request.paymentId())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderId(request.orderId())
                .build();
    }
}
