package de.danilova.jspring.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
    private Long id;


    @Column(name="name")
    private String name;


    @Column(name="price")
    private Integer price;




 @Override
 public String toString() {
  return String.format("Product [id = %d, name = %s, price = %s, weight = %d]", id, name, price);
 }
}
