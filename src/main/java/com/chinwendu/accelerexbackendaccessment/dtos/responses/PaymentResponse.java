package com.chinwendu.accelerexbackendaccessment.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse<T> {
        private boolean status;
        private String message;
        private T data;


        public PaymentResponse(boolean status, String message, T data) {
            this.status = status;
            this.message = message;
            this.data = data;
    }
        public PaymentResponse(boolean status, String message) {
            this.status = status;
            this.message = message;
    }

}
