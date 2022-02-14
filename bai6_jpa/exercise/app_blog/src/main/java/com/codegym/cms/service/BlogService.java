package com.codegym.cms.service;

import com.codegym.cms.model.Blog;
import com.codegym.cms.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void update(Blog blogObj) {
        blogRepository.update(blogObj);
    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }

    @Override
    public void save(Blog blogObj) {
        blogRepository.save(blogObj);
    }
}
