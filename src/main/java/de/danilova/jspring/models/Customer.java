package de.danilova.jspring.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int customerId;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "customers_products",joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns =@JoinColumn(name = "product_id"))
    private List<Product> productList;


    @Override
    public String toString() {
        return String.format("Customer [id = %d, name = %s]", customerId, name);
    }
}
