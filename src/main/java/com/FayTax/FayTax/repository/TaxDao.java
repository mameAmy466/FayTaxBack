package com.FayTax.FayTax.repository;

import com.FayTax.FayTax.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxDao extends JpaRepository<Tax,Long> {
    List<Tax> findByCustomerId(long id);
}
