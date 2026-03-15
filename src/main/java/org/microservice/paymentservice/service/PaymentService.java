package org.microservice.paymentservice.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.microservice.paymentservice.controller.dto.PaymentRequest;
import org.microservice.paymentservice.entity.Payment;
import org.microservice.paymentservice.mapper.PaymentMapper;
import org.microservice.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;

    public Long createPayment(@Valid PaymentRequest request) {
        Payment payment = paymentRepository.save(mapper.requestToEntity(request));



        return ;
    }
}
