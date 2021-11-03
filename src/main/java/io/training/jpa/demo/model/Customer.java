package io.training.jpa.demo.model;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

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

  @Column(name="email")
  @Email
  private String email;

  @OneToOne(mappedBy = "customer")
  private ParkingSpace parkingSpace;

  @OneToMany(mappedBy = "customer")
  private List<Order> orders;





}
