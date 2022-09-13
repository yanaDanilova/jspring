package de.danilova.jspring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;



@Data
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

    //@NotBlank если ставлю эту аннатацию на поля с типом  Integer или Double  вападает вот этот Exception -->
    //javax.validation.UnexpectedTypeException: HV000030: No validator could be found for constraint 'javax.validation.constraints.NotBlank' validating type 'java.lang.Integer'. Check configuration for 'price'
    //для этих типов данных должна быть другая аннотация для такой проверки или в чем проблема?
    @Min(value = 1)
    @Column(name="price")
    private Integer price;

    @Max(value = 1000l, message = "can't be more than 1000g")
    @Column(name="weight")
    private Long weight;

}
