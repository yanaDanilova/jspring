package de.danilova.jspring.repositories;

import de.danilova.jspring.models.Product;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private List<Product> productList;
    private final AtomicLong identity = new AtomicLong(3);
    @PostConstruct
    public void init(){
        this.productList = new ArrayList<>(List.of(
                new Product(1l,"T-Shirt", 25,100l),
                new Product(2l,"Jeans", 70,250l),
                new Product(3l,"Dress", 150, 150l)
        ));
    }

    public List<Product> getProductList(){
        return Collections.unmodifiableList(productList);
    }
    public void addNewProduct(Product product){
        if(product.getId() == null){
            product.setId(identity.incrementAndGet());
        }
        productList.add(product);
    }

    public Optional<Product> findProductById(Long id){
        return productList.stream().filter(p-> Objects.equals((p.getId()), id)).findFirst();
    }
    public void deleteProductById(Long id){
        productList.removeIf(p->(p.getId() == id));
    }
}
