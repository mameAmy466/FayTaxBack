package com.FayTax.FayTax.service;

import com.FayTax.FayTax.model.Customer;
import com.FayTax.FayTax.repository.CustomerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;
    public List<Customer> findAll() {
        return customerDao.findAll();
    }
    public Optional<Customer> findById(Long id) {
        return customerDao.findById(id);
    }
    public Customer save(Customer customer) {
        return customerDao.save(customer);
    }

    public void deleteById(Long id) {
        customerDao.deleteById(id);
    }
}
