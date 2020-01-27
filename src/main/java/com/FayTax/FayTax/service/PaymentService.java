package com.FayTax.FayTax.service;

import com.FayTax.FayTax.model.Payment;
import com.FayTax.FayTax.repository.PaymentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentDao paymentDao;
    public List<Payment> findAll() {
        return paymentDao.findAll();
    }
    public Optional<Payment> findById(Long id) {
        return paymentDao.findById(id);
    }
    public Payment save(Payment payment) {
        return paymentDao.save(payment);
    }

    public void deleteById(Long id) {
        paymentDao.deleteById(id);
    }
}
