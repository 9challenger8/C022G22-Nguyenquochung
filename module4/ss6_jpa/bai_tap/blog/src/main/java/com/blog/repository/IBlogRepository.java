package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value = " select * from blog ",nativeQuery = true)
    List<Blog> findAll();


    @Query(value = "select * from blog where id= :id",nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from blog where id=:id",nativeQuery = true)
    void remove(@Param("id") int id);



}
