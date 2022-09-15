package de.danilova.jspring.services;

import de.danilova.jspring.models.Customer;
import de.danilova.jspring.models.Product;
import de.danilova.jspring.repositories.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao){
        this.customerDao=customerDao;
    }
    public List<Customer> getAllCustomers(){
        return customerDao.findAll();
    }

    public Optional<Customer> getCustomerById(Long id){
        return customerDao.findById(id);
    }


    public void addNewCustomer(Customer customer){
        customerDao.saveOrUpdate(customer);
    }

    public void deleteCustomerById(Long id){
        customerDao.deleteById(id);
    }

    public List<Product> getProductListByCustomerId(Long id){
      return customerDao.getProductListByCustomerId(id);
    }
}
