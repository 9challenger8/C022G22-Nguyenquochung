package com.sprint2_api.service;

import com.sprint2_api.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IBookService {

    Page<Book> getAllBookPagination(Pageable pageable);

    Page<Book> getBookAndSearch(String name, Pageable pageable);

    Book findBookById(Integer id);


}
