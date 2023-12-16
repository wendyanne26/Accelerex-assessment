package com.chinwendu.accelerexbackendaccessment.services;

import com.chinwendu.accelerexbackendaccessment.dtos.requests.PaymentRequest;
import com.chinwendu.accelerexbackendaccessment.dtos.responses.PaymentResponse;
import com.chinwendu.accelerexbackendaccessment.exceptions.CustomException;

public interface TransactionService {

    PaymentResponse handlePayment(PaymentRequest paymentRequest, Long userId) throws CustomException;

    PaymentResponse getAllPayments();
}
