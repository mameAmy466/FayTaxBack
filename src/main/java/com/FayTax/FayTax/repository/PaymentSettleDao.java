package com.FayTax.FayTax.repository;

import com.FayTax.FayTax.model.PaymentSettle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentSettleDao extends JpaRepository<PaymentSettle,Long> {
}
