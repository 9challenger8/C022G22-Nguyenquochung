package com.blog_uprade.service.impl;

import com.blog_uprade.model.Category;
import com.blog_uprade.repository.ICategoryRepository;
import com.blog_uprade.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;


    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void remove(int id) {
        iCategoryRepository.remove(id);

    }

    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id);
    }
}
