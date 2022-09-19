package de.danilova.jspring.controllers;

import de.danilova.jspring.models.Product;
import de.danilova.jspring.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class RestController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProduct(){
      return   productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
         productService.deleteProductById(id);
    }

    @PostMapping
    public void addNewProduct(Product product){
        productService.addNewProduct(product);
    }
}
