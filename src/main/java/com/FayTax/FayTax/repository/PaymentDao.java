package com.FayTax.FayTax.repository;

import com.FayTax.FayTax.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository<Payment ,Long> {
}
