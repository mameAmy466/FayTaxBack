package com.FayTax.FayTax.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Class PaymentSettle
 */
@Data
@Entity
@Table(name = "payment_settle")
public class PaymentSettle implements Serializable {



  // Fields
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name="id")

  private long id;
  @Column(name="amount")
  private long amount;
  @Column(name="date_regulation")
  private Date date_regulation;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "paymentS_tax",
          joinColumns = @JoinColumn(name = "ps_id"),
          inverseJoinColumns = @JoinColumn(name = "tax_id"))
  private Set<Tax> taxes = new HashSet<>();
  @OneToOne
  @PrimaryKeyJoinColumn
  private PaySelect paySelect;
  
  //
  // Constructors
  //
  public PaymentSettle () { };

  public PaymentSettle(long id, long amount, Date date_regulation) {
    this.id = id;
    this.amount = amount;
    this.date_regulation = date_regulation;
  }
  //
  // Methods
  //


  //
  // Accessor methods
  //



}
