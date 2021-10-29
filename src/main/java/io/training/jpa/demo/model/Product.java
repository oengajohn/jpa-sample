package io.training.jpa.demo.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "product_id", nullable = false)
  private int productId;

  @Column(name="product_name",unique = true)
  private  String productName;

  //? Associations
  // A product belongs to one category
  // A category has many products

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;


  @ManyToMany
  private List<Order> orders;

}
