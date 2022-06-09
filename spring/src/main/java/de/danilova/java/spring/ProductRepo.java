package de.danilova.java.spring;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo {

    private List<Product> productList;

    @PostConstruct
    public void init(){
        this.productList = new ArrayList<>(List.of(
                new Product(1,"Dress"),
                new Product(2,"T-Shirt"),
                new Product(3,"Jeans")
        ));
    }

    public Optional<Product> findProductById(Integer id){
      return  productList.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public List<Product> getProductList(){
        return Collections.unmodifiableList(productList);
    }

    public void addProductToList(Product product){
        productList.add(product);
    }

    public void deleteProductFromListById(Integer id){
        productList.removeIf(product -> product.getId().equals(id));
    }

    public void deleteAllProductFromList(){
        productList.removeAll(productList);
    }
}
