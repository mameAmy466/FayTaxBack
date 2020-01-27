package com.FayTax.FayTax.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * Class Customer
 */
@Data
public class CustomerForm{
  //
  // Fields
  //
  private long id;
  private String name;
  private String first_name;
  private String email;
  private String address;
  private String login;
  private String password;
  private List<Tax> taxes;

  //
  // Constructors
  //
  public CustomerForm() {};
  
  //
  // Methods
  //


}
