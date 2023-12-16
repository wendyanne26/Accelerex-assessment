package com.chinwendu.accelerexbackendaccessment.models;

import com.chinwendu.accelerexbackendaccessment.dtos.requests.PaymentRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends AuditClass{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private String paymentMethod;
    private Long userId;

    private Payment(PaymentRequest paymentRequest) {
        this.amount = BigDecimal.valueOf(Double.parseDouble(paymentRequest.getAmount()));
        this.paymentMethod = paymentRequest.getPaymentMethod();
    }
    public static Payment createPaymentInstance(PaymentRequest paymentRequest){
        return new Payment(paymentRequest);
    }
}
