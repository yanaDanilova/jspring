package de.danilova.jspring.services;

import de.danilova.jspring.models.Customer;
import de.danilova.jspring.models.Product;
import de.danilova.jspring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerDao){
        this.customerRepository=customerDao;
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }


    public void addNewCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }

    public List<Product> getProductListByCustomerId(Long id){
      return customerRepository.getProductListByCustomerId(id);
    }
}
