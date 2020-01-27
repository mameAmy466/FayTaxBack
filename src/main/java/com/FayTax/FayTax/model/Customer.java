package com.FayTax.FayTax.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;


/**
 * Class Customer
 */
@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
  //
  // Fields
  //
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
@NotNull
@Column(name = "name")
  private String name;
  @NotNull
  @Column(name = "first_name")
  private String first_name;
  @NotNull
  @Email
  private String email;
  @NotNull
  @Column(name = "address")
  private String address;
  @OneToMany(mappedBy ="customer", cascade = CascadeType.ALL)
  @JsonIgnoreProperties("customer")
  private List<User> users;
  @OneToMany(mappedBy ="customer", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Tax> Taxes;
  //
  // Constructors
  //
  public Customer () { };
  
  //
  // Methods
  //


}
