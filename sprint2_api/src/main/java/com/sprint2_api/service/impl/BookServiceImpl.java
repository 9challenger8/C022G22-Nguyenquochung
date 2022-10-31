package com.sprint2_api.service.impl;

import com.sprint2_api.model.Book;
import com.sprint2_api.repository.IBookRepository;
import com.sprint2_api.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> getAllBookPagination(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> getBookAndSearch(String name, Pageable pageable) {
        return iBookRepository.getBookAndSearch(name,pageable);
    }

    @Override
    public Book findBookById(Integer id) {
        return iBookRepository.findBookById(id);
    }
}
