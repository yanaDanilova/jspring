package de.danilova.jspring.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

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

    @NotBlank(message = "can't be empty")
    @Column(name="name")
    private String name;

   // @ManyToMany
  //  @JoinTable(name = "customers_products",joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns =@JoinColumn(name = "customer_id"))
  //  private List<Customer> customerList;

    @Min(value = 1)
    @Column(name="price")
    private Integer price;

    @Max(value = 1000l, message = "can't be more than 1000g")
    @Column(name="weight")
    private Long weight;


 @Override
 public String toString() {
  return String.format("Product [id = %d, name = %s, price = %s, weight = %d]", id, name, price, weight);
 }
}
