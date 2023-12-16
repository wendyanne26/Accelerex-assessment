package com.chinwendu.accelerexbackendaccessment.repositories;

import com.chinwendu.accelerexbackendaccessment.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
