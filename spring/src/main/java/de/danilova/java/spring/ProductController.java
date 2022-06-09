package de.danilova.java.spring;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/v1/products")
    public List<Product> getListOfProducts(){
      return  productService.getAllProduct();
    }

    @GetMapping("/api/v1/products/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id){
       return productService.getProductById(id);
    }

    @PostMapping("/api/v1/products")
    public void addNewProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping("/api/v1/products/{id}")
    public void deleteProductById(@PathVariable Integer id){
        productService.deleteProductById(id);
    }

    @DeleteMapping("/api/v1/products")
    public void deleteAllProduct(){
        productService.deleteAllProduct();
    }
}
