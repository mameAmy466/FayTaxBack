package com.FayTax.FayTax.api;

import com.FayTax.FayTax.model.*;
import com.FayTax.FayTax.service.CustomerService;
import com.FayTax.FayTax.service.PaymentService;
import com.FayTax.FayTax.service.TaxService;
import com.FayTax.FayTax.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/fayTax/")
@Slf4j
@RequiredArgsConstructor
public class CustomerApi {
    private final UserService UserService;
    private final CustomerService customerService;
    private  final TaxService taxService;
    private final PaymentService paymentService;
    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping(value = "addCustomer", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@Valid @RequestBody(required = false)CustomerForm customerForm) {
        Customer customer = new Customer();
        User user = new User();
        customer.setName(customerForm.getName());
        customer.setFirst_name(customerForm.getFirst_name());
        customer.setAddress(customerForm.getAddress());
        customer.setEmail(customerForm.getEmail());
        user.setLogin(customerForm.getLogin());
        user.setPassword(customerForm.getPassword());
        user.setCustomer(customer);
        customerForm.getTaxes().forEach(
                tax -> {
                    tax.setCustomer(customer);
                    taxService.save(tax); });
        UserService.save(user);
        return ResponseEntity.ok(customerService.save(customer));
    }
    @GetMapping("taxes/{id}")
    public  ResponseEntity<List<Tax>> findAllCustomerTax(@PathVariable long id){
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(taxService.findByCustomerId(customer.get().getId()));
    }
    @PostMapping(value = "addPayment", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public  ResponseEntity<Payment> addPayment(@Valid @RequestBody(required = false) PaymentForm paymentForm){
        Payment payment = new Payment();

        return  ResponseEntity.ok(paymentService.save(payment));
    }
}