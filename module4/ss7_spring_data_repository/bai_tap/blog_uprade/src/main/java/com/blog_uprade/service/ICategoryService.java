package com.blog_uprade.service;

import com.blog_uprade.model.Blog;
import com.blog_uprade.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void remove(@Param("id") int id);

    void save(Category category);

}
