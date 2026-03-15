package org.microservice.paymentservice.controller.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        @NotBlank
        String customerId,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        String email
) {
}
