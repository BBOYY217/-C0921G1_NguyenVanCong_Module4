package com.codegym.cms.repository;


import com.codegym.cms.model.Blog;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        String queryString = "SELECT b FROM Blog as b";
        TypedQuery<Blog> query = entityManager.createQuery(queryString, Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        String queryString = "SELECT b FROM Blog b WHERE b.id = :id";
        TypedQuery<Blog> query = entityManager.createQuery(queryString, Blog.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void update(Blog blogObj) {
        if (blogObj.getId()!=null){
            entityManager.merge(blogObj);
        }else{
            entityManager.persist(blogObj);
        }
    }

    @Override
    public void delete(Long id) {
        Blog blogObj = findById(id);
        if (blogObj != null){
            entityManager.remove(blogObj);
        }
    }

    @Override
    public void save(Blog blogObj) {
        if (blogObj.getId() != null) {
            entityManager.merge(blogObj);
        } else {
            entityManager.persist(blogObj);
        }
    }
    }

