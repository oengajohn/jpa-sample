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
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "product_id")
  private int id;

  @Column(unique = true,length = 50)
  @Size(min=3,max = 50)
  private  String productName;

  private double price;

  //? Associations
  // A product belongs to one category
  // A category has many products

  @ManyToOne(optional = false)
  @JoinColumn(name = "category_id")
  private Category category;


  @ManyToMany(mappedBy = "products")
  private List<Order> orders;

}
