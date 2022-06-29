package com.ung_dung_thu_vien.repository;

import com.ung_dung_thu_vien.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book",nativeQuery = true)
    List<Book> findAll();

    @Query(value = "select * from book where id = :id",nativeQuery = true)
    Book findById(@Param("id") int id);

}
