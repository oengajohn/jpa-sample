package io.training.jpa.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceException;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="parking_spaces")
public class ParkingSpace {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(unique = true)
  private String code;

  private boolean available;

  @OneToOne
  @JoinColumn(name="customer_id")
  private Customer customer;

  @PrePersist
  public void setDefaults(){
    this.setAvailable(true);
  }
  @PreUpdate
  public void beforeUpdate(){
    if(!isAvailable() && customer ==null){
      throw new PersistenceException("No Corruption: =>You can't update the status of the parking space to not available without linking it to a customer");


    }
  }



}
