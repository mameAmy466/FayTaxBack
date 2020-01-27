package com.FayTax.FayTax.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;




/**
 * Class Payment
 */
@Data
@Entity
@Table(name = "payment")
public class Payment implements Serializable {

  //
  // Fields
  //
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
@Column(name = "status")
  private boolean status;
  @OneToMany(mappedBy ="payment", cascade = CascadeType.ALL)
  @JsonIgnoreProperties("payment")
  private List<PaySelect> paySelects;
  @JoinColumn(name = "tax_id",referencedColumnName ="id")
  @OneToOne
  @PrimaryKeyJoinColumn
  private Tax tax;
  //

  //
  // Constructors
  //
  public Payment () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //


}
