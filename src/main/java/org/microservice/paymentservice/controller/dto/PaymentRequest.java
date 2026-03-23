package org.microservice.paymentservice.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.microservice.paymentservice.entity.PaymentMethodEnum;

import java.math.BigDecimal;

public record PaymentRequest(
        Long paymentId,
        @Positive
        BigDecimal amount,
        @NotNull
        PaymentMethodEnum paymentMethod,
        @NotNull
        Long orderId,
        @NotBlank
        String orderReference,
        @NotNull
        Customer customer
) {
}
