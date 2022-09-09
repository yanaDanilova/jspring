package de.danilova.jspring.services;


import de.danilova.jspring.models.Product;
import de.danilova.jspring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.getProductList();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findProductById(id);
    }


    public void addNewProduct(Product product){
        productRepository.addNewProduct(product);
    }

    public void deleteProductById(Long id){
        productRepository.deleteProductById(id);
    }
}
