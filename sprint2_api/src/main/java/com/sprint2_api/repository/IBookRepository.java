package com.sprint2_api.repository;

import com.sprint2_api.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "select * from book where name like concat('%',:name,'%') order by id desc",nativeQuery = true,
    countQuery = "count (*) from (select * from book where name like concat('%',:name,'%') order by id desc) abc")
    Page<Book> getBookAndSearch(@Param("name") String name,Pageable pageable);

    Book findBookById(Integer id);



}
