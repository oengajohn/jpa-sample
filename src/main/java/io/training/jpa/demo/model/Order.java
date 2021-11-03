package io.training.jpa.demo.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "order_id", nullable = false)
  private int orderId;

  // An order contains many products
  // Many products can be in the same order

  @ManyToMany
  @JoinTable(
      name = "order_items",
      joinColumns = @JoinColumn(name = "ORD_ID", referencedColumnName = "order_id"),
      inverseJoinColumns = @JoinColumn(name="PRO_ID",referencedColumnName ="product_id" )
  )
  private List<Product> products;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

//  private LocalDate createdAt;
//  private LocalDate updatedAt;

//  @Past
//  private LocalDate dob;

//defined states Pending, in transit, shipped
  //ordinal
  // string

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;


  @PrePersist
  public void beforeSave() {
    this.setOrderStatus(OrderStatus.PENDING);
//    this.setCreatedAt(LocalDate.now());
//    this.setUpdatedAt(LocalDate.now());
  }

  @PreUpdate
  public void beforeUpdate() {
//    this.setUpdatedAt(LocalDate.now());

  }

}
