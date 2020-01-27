package com.FayTax.FayTax.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


import java.util.*;


/**
 * Class PaySelect
 */
@Data
@Entity
@Table(name = "payment_select")
public class PaySelect {


  // Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "amount_select")
  private long amount_select;
  @JoinColumn(name = "payment_id",referencedColumnName ="id")
  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  @JsonIgnoreProperties("paySelects")
  private  Payment payment;
  @OneToOne
  @PrimaryKeyJoinColumn
  private PaymentMethod paymentMethod;
  @OneToOne
  @PrimaryKeyJoinColumn
  private PaymentSettle paymentSettle;

  //
  // Constructors
  //
  public PaySelect () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //


}
