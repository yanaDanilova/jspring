package de.danilova.jspring.controllers;



import de.danilova.jspring.models.Product;
import de.danilova.jspring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("product", productService.getProductById(id));
        return "product_form";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "product_form" ;
    }


    @PostMapping("/addProduct")
    public String addProduct(@Valid Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "product_form";
        }
        productService.addNewProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") long id){
        productService.deleteProductById(id);
        return "redirect:/products";
    }



}
