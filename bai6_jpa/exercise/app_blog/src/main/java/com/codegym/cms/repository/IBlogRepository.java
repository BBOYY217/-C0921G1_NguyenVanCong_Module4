package com.codegym.cms.repository;

import com.codegym.cms.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    Blog findById (Long id);
    void update (Blog blogObj);
    void delete (Long id);
    void save(Blog blogObj);
}
