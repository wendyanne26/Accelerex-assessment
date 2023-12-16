package com.chinwendu.accelerexbackendaccessment.paymentConfig;

import com.chinwendu.accelerexbackendaccessment.dtos.requests.PaymentRequest;
import com.chinwendu.accelerexbackendaccessment.exceptions.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentProcessorImpl implements PaymentProcessor{
    private final PaymentFactory paymentFactory;
    public void processPayment(PaymentRequest paymentRequest) throws CustomException {
        PaymentService service = paymentFactory.selectPaymentService(paymentRequest.getPaymentMethod());
        service.makePayment(paymentRequest.getAmount());
    }
}
