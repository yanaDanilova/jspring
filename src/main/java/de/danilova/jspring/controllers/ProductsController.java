/*
package de.danilova.jspring.controllers;
import de.danilova.jspring.exception.EntityNotFoundException;
import de.danilova.jspring.models.Product;
import de.danilova.jspring.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;



    @GetMapping
    public String showAllProducts(Model model){
       model.addAttribute("products",productService.getAllProducts());
       return  "products";
    }


    @GetMapping("/{id}")
    public String form(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", productService.getProductById(id).orElseThrow(()-> new EntityNotFoundException(String.format("User with id %s not found", id))));
        return "product_form";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "product_form" ;
    }


    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product){
        productService.addNewProduct(product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return "redirect:/products";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundExceptionHandler(Model model, EntityNotFoundException e) {
        model.addAttribute("message", e.getMessage());
        return "not_found";
    }




}
*/