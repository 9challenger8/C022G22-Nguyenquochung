package com.service.impl;

import com.model.Song;
import com.repository.ISongRepository;
import com.service.ISongService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

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
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void update(int id, Song song) {
         iSongRepository.update(id,song);
    }

    @Override
    public void remove(int id) {
        iSongRepository.remove(id);
    }

    @Override
    public List<Song> findByName(String name) {
        return null;
    }
}
