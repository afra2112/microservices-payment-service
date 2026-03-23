package org.microservice.paymentservice.kafka;

import org.microservice.paymentservice.entity.PaymentMethodEnum;
import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethodEnum paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
