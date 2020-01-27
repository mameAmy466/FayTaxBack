package com.FayTax.FayTax.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;


import java.util.*;


/**
 * Class PaymentMethod_
 */
@Data
@Entity
@Table(name = "payment_method")
public class PaymentMethod  implements Serializable {

  //
  // Fields
  //
  @Id
  @GeneratedValue
  private long id;
  @NotNull
  private String name;
  @OneToOne
  @PrimaryKeyJoinColumn
  private Payment payment;
  
  //
  // Constructors
  //
  public PaymentMethod() { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //



}
