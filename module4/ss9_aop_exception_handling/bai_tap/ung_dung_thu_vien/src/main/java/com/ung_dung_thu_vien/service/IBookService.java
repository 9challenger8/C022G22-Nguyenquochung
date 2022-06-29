package com.ung_dung_thu_vien.service;

import com.ung_dung_thu_vien.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(@Param("id") int id);

    void save(Book book);
}
