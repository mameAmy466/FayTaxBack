package com.FayTax.FayTax.model;

import lombok.Data;

import java.util.List;


/**
 * Class PaymentForm
 */
@Data
public class PaymentForm {
  //
  // Fields
  //
  private List<Tax> taxes;
  private List<Payment> Payments;

  //
  // Constructors
  //
  public PaymentForm() {};
  
  //
  // Methods
  //


}
