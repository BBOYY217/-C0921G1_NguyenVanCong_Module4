package com.codegym.repository;

import com.codegym.model.Music;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class MusicRepositoryImpl implements MusicRepository {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Music> findAll() {
        String queryString = "SELECT m from Music AS m";
        TypedQuery<Music> query = entityManager.createQuery(queryString, Music.class);
        return query.getResultList();
    }

    @Override
    public Music save(Music musicObj) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music musicOrgin = findById(musicObj.getId());
            musicOrgin.setName(musicObj.getName());
            musicOrgin.setArtist(musicObj.getArtist());
            musicOrgin.setTypeOfMusic(musicObj.getTypeOfMusic());
            musicOrgin.setFilePath(musicObj.getFilePath());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return musicObj;
    }

    @Override
    public Music findById(int id) {
        String queryString = "SELECT m FROM Music AS m WHERE m.id = :id";
        TypedQuery<Music> query = entityManager.createQuery(queryString, Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Music update(Music musicObj) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music musicOrgin = findById(musicObj.getId());
            musicOrgin.setName(musicObj.getName());
            musicOrgin.setArtist(musicObj.getArtist());
            musicOrgin.setTypeOfMusic(musicObj.getTypeOfMusic());
            musicOrgin.setFilePath(musicObj.getFilePath());
            session.saveOrUpdate(musicObj);
            transaction.commit();
            return musicObj;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music musicObj = findById(id);
            if (musicObj != null) {
                session.delete(musicObj);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Music> searchByName(String string) {
        List<Music> musicListSearch = new ArrayList<>();
        List<Music> musicList = findAll();
        for (Music music : musicList) {
            if (music.getName().contains(string)) {
                musicListSearch.add(music);
            }
        }
        return musicListSearch;
    }
}
