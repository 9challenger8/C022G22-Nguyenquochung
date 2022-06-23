package com.blog_uprade.service.impl;

import com.blog_uprade.model.Blog;
import com.blog_uprade.repository.IBlogRepository;
import com.blog_uprade.service.IBLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Blog> findAllByName(String name, Pageable pageable) {
        return this.iBlogRepository.findAllByName(name,pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.findAll(pageable);
    }


}
