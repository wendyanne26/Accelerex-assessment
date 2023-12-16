package com.chinwendu.accelerexbackendaccessment.controllers;

import com.chinwendu.accelerexbackendaccessment.dtos.requests.PaymentRequest;
import com.chinwendu.accelerexbackendaccessment.exceptions.CustomException;
import com.chinwendu.accelerexbackendaccessment.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/payment")
public class PaymentController {
    private final TransactionService transactionService;
    @PostMapping("/make-payment/{userId}")
    public ResponseEntity<?> makePayment(@RequestBody PaymentRequest paymentRequest, @PathVariable Long userId) throws CustomException {
    return new ResponseEntity<>(transactionService.handlePayment(paymentRequest,userId), HttpStatus.OK);
    }
    @GetMapping("get-payment")
    public ResponseEntity<?> getPayments(){
        return new ResponseEntity<>(transactionService.getAllPayments(), HttpStatus.OK);
    }
}
