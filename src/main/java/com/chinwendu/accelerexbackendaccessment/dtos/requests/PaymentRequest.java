package com.chinwendu.accelerexbackendaccessment.dtos.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentRequest {
    private String amount;
    private String paymentMethod;

    public PaymentRequest(String amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }
}
