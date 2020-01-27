package com.FayTax.FayTax.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;




/**
 * Class Tax
 */
@Data
@Entity
@Table(name = "tax")
public class Tax implements Serializable {

  //
  // Fields
  //
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
@NotNull
@Column(name = "nature")
  private String nature;
  @JsonFormat(pattern ="yyyy-MM-dd")
  private LocalDate period_taxation;
  private long document_number;
  @JsonFormat(pattern ="yyyy-MM-dd")
  private LocalDate eligibility_date;
  private long amount;
  @JoinColumn(name = "customer_id",referencedColumnName ="id")
  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  @JsonIgnore
  private Customer customer;
  //
  // Constructors
  //
  public Tax () { };



}
