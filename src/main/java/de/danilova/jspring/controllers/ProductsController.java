package de.danilova.jspring.controllers;
import de.danilova.jspring.exception.EntityNotFoundException;
import de.danilova.jspring.models.Product;
import de.danilova.jspring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController ( ProductService productService){
        this.productService = productService;
    }

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
    public String addProduct(@RequestBody @Valid Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "product_form";
        }
        productService.addNewProduct(product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id){
        productService.deleteProductById(id);
        return "redirect:/products";
    }

    //вроде бы все сделала как вы на уроке, но почему то все равно не показывает страницу not_found. Продолжает показывать: Whitelabel Error Page
    //This application has no explicit mapping for /error, so you are seeing this as a fallback.
    //
    //Tue Sep 13 09:14:14 CEST 2022
    //There was an unexpected error (type=Internal Server Error, status=500).
    //могли бы вы подсказать в чем проблема?
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundExceptionHandler(Model model, EntityNotFoundException e) {
        model.addAttribute("message", e.getMessage());
        return "not_found";
    }




}
