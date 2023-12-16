package com.chinwendu.accelerexbackendaccessment.paymentConfig;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CardPaymentService implements PaymentService {
   @Override
    public void makePayment(String amount) {
       System.out.println(amount + " payment made with card");
    }
}
