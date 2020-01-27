package com.FayTax.FayTax.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Class User
 */
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
  //
  // Fields
  //
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;
  @NotNull
  @Column(name ="login")
  private String login;
  @NotNull
  @Column(name ="password")
  private String password;
  @JoinColumn(name = "customer_id",referencedColumnName ="id")
  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  @JsonIgnore
  private Customer customer;

  //
  // Constructors
  //
  public User () { };


  //
  // Methods
  //


  //
  // Accessor methods
  //

}
