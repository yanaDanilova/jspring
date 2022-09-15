package de.danilova.jspring.repositories;

import de.danilova.jspring.models.Customer;
import de.danilova.jspring.models.Product;
import de.danilova.jspring.utils.HibernateUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDao {
    private HibernateUtils hibernateUtils;

    @Autowired
    public CustomerDao(HibernateUtils hibernateUtils){
        this.hibernateUtils = hibernateUtils;
    }

    public Optional<Customer> findById(Long id){
        Session session =hibernateUtils.getCurrentSession();
        session.beginTransaction();
        Optional<Customer> customer =Optional.ofNullable(session.get(Customer.class, id));
        System.out.println(customer);
        session.getTransaction().commit();
        return customer;
    }


    public List<Customer> findAll(){
        Session session = hibernateUtils.getCurrentSession();
        session.beginTransaction();
        List customerList = session.createQuery("from Customer").getResultList();
        session.getTransaction().commit();
        System.out.println(customerList);
        return customerList;


    }

    public void deleteById(Long id){
        Session session = hibernateUtils.getCurrentSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        session.getTransaction().commit();

    }

    public void saveOrUpdate(Customer customer){
        Session session = hibernateUtils.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(customer);
        session.getTransaction().commit();

    }

    public List<Product> getProductListByCustomerId(Long id){
        Session session = hibernateUtils.getCurrentSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        List<Product> productList = customer.getProductList();
        session.getTransaction().commit();
        return productList;
    }
}
