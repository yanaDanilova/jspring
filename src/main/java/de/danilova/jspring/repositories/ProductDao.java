package de.danilova.jspring.repositories;

import de.danilova.jspring.models.Product;
import de.danilova.jspring.utils.HibernateUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProductDao {
    private HibernateUtils hibernateUtils;

    @Autowired
    public ProductDao(HibernateUtils hibernateUtils){
        this.hibernateUtils=hibernateUtils;
    }
    public Optional<Product> findById(Long id){
        Session session =hibernateUtils.getCurrentSession();
            session.beginTransaction();
            Optional<Product> product =Optional.ofNullable(session.get(Product.class, id));
            System.out.println(product);
            session.getTransaction().commit();
            return product;
        }


    public List<Product> findAll(){
        Session session = hibernateUtils.getCurrentSession();
            session.beginTransaction();
            List productList = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            System.out.println(productList);
            return productList;


    }

    public void deleteById(Long id){
        Session session = hibernateUtils.getCurrentSession();
            session.beginTransaction();
            Product product = session.get(Product.class, id);
        session.delete(product);
            session.getTransaction().commit();

    }

    public void saveOrUpdate(Product product){
        Session session = hibernateUtils.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();

    }

}
