package de.danilova.java.spring;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProduct(){
       return productRepo.getProductList();
    }

    public Optional<Product> getProductById(Integer id){
        return productRepo.findProductById(id);
    }

    public void addProduct(Product product){
        productRepo.addProductToList(product);
    }

    public void deleteProductById(Integer id){
        productRepo.deleteProductFromListById(id);
    }

    public void deleteAllProduct(){
        productRepo.deleteAllProductFromList();
    }
}
