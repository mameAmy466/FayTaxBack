package com.FayTax.FayTax.service;

import com.FayTax.FayTax.model.Tax;
import com.FayTax.FayTax.repository.TaxDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TaxService {

    private final TaxDao taxDao;
    public List<Tax> findAll() {
        return taxDao.findAll();
    }
    public List<Tax> findByCustomerId(long id) {
        return taxDao.findByCustomerId(id);
    }
    public Optional<Tax> findById(Long id) {
        return taxDao.findById(id);
    }
    public Tax save(Tax tax) {
        return taxDao.save(tax);
    }

    public void deleteById(Long id) {
        taxDao.deleteById(id);
    }
}
