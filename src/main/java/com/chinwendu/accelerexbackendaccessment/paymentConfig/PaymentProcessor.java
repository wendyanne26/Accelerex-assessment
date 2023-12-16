package com.chinwendu.accelerexbackendaccessment.paymentConfig;

import com.chinwendu.accelerexbackendaccessment.dtos.requests.PaymentRequest;
import com.chinwendu.accelerexbackendaccessment.exceptions.CustomException;

public interface PaymentProcessor {
    void processPayment(PaymentRequest paymentRequest) throws CustomException;
}
