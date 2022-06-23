package com.blog_uprade.repository;

import com.blog_uprade.model.Blog;
import com.blog_uprade.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = " select * from category ",nativeQuery = true)
    List<Category> findAll();

    @Modifying
    @Transactional
    @Query(value = "delete from blog where id=:id",nativeQuery = true)
    void remove(@Param("id") int id);
}
