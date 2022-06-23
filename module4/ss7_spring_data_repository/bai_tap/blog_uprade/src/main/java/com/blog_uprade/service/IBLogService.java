package com.blog_uprade.service;


import com.blog_uprade.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBLogService  {
    List<Blog> findAll();


    Blog findById(@Param("id") int id);


    void remove(@Param("id") int id);

    void save(Blog blog);

    Page<Blog> findAllByName(String name, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);
}
