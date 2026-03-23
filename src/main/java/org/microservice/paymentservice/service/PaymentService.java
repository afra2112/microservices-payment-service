package org.microservice.paymentservice.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.microservice.paymentservice.controller.dto.PaymentRequest;
import org.microservice.paymentservice.entity.Payment;
import org.microservice.paymentservice.kafka.NotificationProducer;
import org.microservice.paymentservice.kafka.PaymentNotificationRequest;
import org.microservice.paymentservice.mapper.PaymentMapper;
import org.microservice.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final NotificationProducer notificationProducer;
    private final PaymentMapper mapper;

    public Long createPayment(@Valid PaymentRequest request) {
        notificationProducer.sendNotification(new PaymentNotificationRequest(
                request.orderReference(),
                request.amount(),
                request.paymentMethod(),
                request.customer().firstName(),
                request.customer().lastName(),
                request.customer().email()
        ));
        return paymentRepository.save(mapper.requestToEntity(request)).getPaymentId();
    }
}
