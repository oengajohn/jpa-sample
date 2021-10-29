package io.training.jpa.demo.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
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

  @ManyToMany(mappedBy ="orders")
  private List<Product> products;


//defined states Pending, in transit, shipped
  //ordinal
  // string

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;


  @PrePersist
  public  void setDefaultStatus(){
    this.setOrderStatus(OrderStatus.PENDING);
  }


}
