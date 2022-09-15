package de.danilova.jspring.utils;

import de.danilova.jspring.models.Customer;
import de.danilova.jspring.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HibernateUtils {
    private SessionFactory sessionFactory;


    @PostConstruct
    public void init(){
        sessionFactory= new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        try(Session session = sessionFactory.getCurrentSession()) {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            Product product = session.get(Product.class,1l);
            List<Customer> customerList = product.getCustomerList();
            System.out.println(customerList);
            session.getTransaction().commit();




        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @PreDestroy
    public  void shutdown() {
        if(sessionFactory != null){
            sessionFactory.close();
        }

    }


}
