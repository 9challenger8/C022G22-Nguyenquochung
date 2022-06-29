package com.ung_dung_thu_vien.service.impl;

import com.ung_dung_thu_vien.model.Book;
import com.ung_dung_thu_vien.repository.IBookRepository;
import com.ung_dung_thu_vien.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository iBookRepository;


    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }
}
