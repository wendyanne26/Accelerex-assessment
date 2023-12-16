package com.chinwendu.accelerexbackendaccessment;

import com.chinwendu.accelerexbackendaccessment.dtos.requests.PaymentRequest;
import com.chinwendu.accelerexbackendaccessment.dtos.responses.PaymentResponse;
import com.chinwendu.accelerexbackendaccessment.exceptions.CustomException;
import com.chinwendu.accelerexbackendaccessment.models.Payment;
import com.chinwendu.accelerexbackendaccessment.paymentConfig.PaymentProcessorImpl;
import com.chinwendu.accelerexbackendaccessment.repositories.PaymentRepository;
import com.chinwendu.accelerexbackendaccessment.services.serviceImpl.PaymentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PaymentServiceTest {
    @Mock
    private PaymentProcessorImpl paymentProcessorImpl;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void handlePayment_Success() throws CustomException {
        // Mock data
        PaymentRequest paymentRequest = new PaymentRequest("100.00", "card");
        Long userId = 1L;
        // Mock behavior of paymentProcessor
        doNothing().when(paymentProcessorImpl).processPayment(paymentRequest);

        // Stubbing save method of paymentRepository
        Payment savedPayment = new Payment(); // Create a Payment instance for verification
        savedPayment.setUserId(userId);
        savedPayment.setAmount(BigDecimal.valueOf(Double.parseDouble(paymentRequest.getAmount())));
        savedPayment.setPaymentMethod(paymentRequest.getPaymentMethod());
        when(paymentRepository.save(any(Payment.class))).thenReturn(savedPayment);

        // Call the method under test
        PaymentResponse response = paymentService.handlePayment(paymentRequest, userId);
        response.setData(savedPayment);

        // Verify behavior
        verify(paymentProcessorImpl).processPayment(paymentRequest);
        verify(paymentRepository).save(any(Payment.class));

        // Assertions
        assertEquals("success", response.getMessage());
        assertEquals(savedPayment, response.getData()); // Verify the saved payment is returned in the response
    }

    @Test
    void getAllPayments_Success() {
       Payment payment1 = new Payment();
       Payment payment2 = new Payment();

        // Mocking data
        List<Payment> mockPayments = new ArrayList<>();
        mockPayments.add(payment1);
        mockPayments.add(payment2);

        // Mock behavior of paymentRepository
        when(paymentRepository.findAll()).thenReturn(mockPayments);

        // Call the method under test
        PaymentResponse response = paymentService.getAllPayments();
        response.setData(mockPayments);

        // Verify behavior
        assertEquals("success", response.getMessage());
        assertEquals(mockPayments, response.getData());
    }

}


