package com.service.impl;

import com.model.Product;
import com.service.IProductService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static{
        try{
            sessionFactory = new Configuration().configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        String queryStr = " select s from Product s";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
        }
        catch (HibernateException e){
            if(tx != null){
                tx.rollback();
                e.printStackTrace();
            }
        }
        finally {
            session.close();
        }

    }

    @Override
    public Product findById(int id) {
        String queryStr = " select s from Product s where id = :id";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(int id, Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Product origin = findById(id);
            origin.setName(product.getName());
            origin.setPrice(product.getPrice());
            origin.setDetail(product.getDetail());
            origin.setProducer(product.getProducer());
            session.update(origin);
            tx.commit();
        }
        catch (HibernateException e){
            if(tx != null){
                tx.rollback();
                e.printStackTrace();
            }
        }
        finally {
            session.close();
        }
    }

    @Override
    public void remove(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Product origin = findById(id);
            session.delete(origin);
            tx.commit();
        }
        catch (HibernateException e){
            if(tx != null){
                tx.rollback();
                e.printStackTrace();
            }
        }
        finally {
            session.close();
        }

    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}
