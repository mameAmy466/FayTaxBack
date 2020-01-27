package com.FayTax.FayTax.repository;

import com.FayTax.FayTax.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodDao extends JpaRepository <PaymentMethod ,Long> {
}
