package com.blog.service;


import com.blog.model.Blog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IBLogService  {
    List<Blog> findAll();


    Blog findById(@Param("id") int id);


    void remove(@Param("id") int id);

    void save(Blog blog);


}
