package io.training.jpa.demo.model;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int customerId;

  @Column(name="full_name")
  private String name;

  @Column(name="cellphone")
  private String phoneNumber;



}
