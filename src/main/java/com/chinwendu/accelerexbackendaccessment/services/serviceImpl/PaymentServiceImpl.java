package com.chinwendu.accelerexbackendaccessment.services.serviceImpl;
import com.chinwendu.accelerexbackendaccessment.dtos.requests.PaymentRequest;
import com.chinwendu.accelerexbackendaccessment.dtos.responses.PaymentResponse;
import com.chinwendu.accelerexbackendaccessment.exceptions.CustomException;
import com.chinwendu.accelerexbackendaccessment.models.Payment;
import com.chinwendu.accelerexbackendaccessment.paymentConfig.PaymentProcessorImpl;
import com.chinwendu.accelerexbackendaccessment.repositories.PaymentRepository;
import com.chinwendu.accelerexbackendaccessment.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.chinwendu.accelerexbackendaccessment.models.Payment.createPaymentInstance;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements TransactionService {
    private final PaymentRepository paymentRepository;
    private final PaymentProcessorImpl paymentProcessorImpl;
    @Override
    public PaymentResponse handlePayment(PaymentRequest paymentRequest, Long userId) throws CustomException {
        paymentProcessorImpl.processPayment(paymentRequest);
        Payment payment = createPaymentInstance(paymentRequest);
        payment.setUserId(userId);
        paymentRepository.save(payment);
        return new PaymentResponse(true, "success", payment);
    }

    @Override
    public PaymentResponse getAllPayments() {
        List<Payment> allPayments = paymentRepository.findAll();
        return new PaymentResponse<>(true, "success", allPayments);
    }
}
