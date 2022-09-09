package de.danilova.jspring.services;


import de.danilova.jspring.models.Product;
import de.danilova.jspring.repositories.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao){
        this.productDao = productDao;
    }
    public List<Product> getAllProducts(){
        return productDao.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productDao.findById(id);
    }


    public void addNewProduct(Product product){
        productDao.saveOrUpdate(product);
    }

    public void deleteProductById(Long id){
        productDao.deleteById(id);
    }
}
