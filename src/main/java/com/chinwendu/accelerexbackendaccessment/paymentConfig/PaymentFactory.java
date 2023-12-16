package com.chinwendu.accelerexbackendaccessment.paymentConfig;

import com.chinwendu.accelerexbackendaccessment.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {
   public PaymentService selectPaymentService(String paymentMethod) throws CustomException {
      return switch (paymentMethod){
         case "card" -> new CardPaymentService();
         default -> throw new CustomException("Invalid payment method: " + paymentMethod, HttpStatus.INTERNAL_SERVER_ERROR);
      };
   }
}
