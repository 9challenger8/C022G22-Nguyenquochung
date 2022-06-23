package com.blog.service.impl;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import com.blog.service.IBLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements IBLogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.remove(id);

    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

}
