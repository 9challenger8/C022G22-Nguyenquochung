package com.repository.impl;

import com.model.Song;
import com.repository.ISongRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;




@Repository
public class SongRepositoryImpl implements ISongRepository {

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
    public List<Song> findAll() {
        String queryStr = " select s from Song s";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(song);
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
    public Song findById(int id) {
        String queryStr = " select s from Song s where id = :id";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(int id, Song song) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Song origin = findById(id);
            origin.setName(song.getName());
            origin.setArtist(song.getArtist());
            origin.setTypeMusic(song.getTypeMusic());
            origin.setUrl(song.getUrl());
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
            Song origin = findById(id);
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
    public List<Song> findByName(String name) {
        return null;
    }

}
