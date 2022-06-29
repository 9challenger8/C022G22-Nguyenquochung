package com.ung_dung_thu_vien.service.impl;

import com.ung_dung_thu_vien.model.BookDetail;
import com.ung_dung_thu_vien.repository.IBookDetailRepository;
import com.ung_dung_thu_vien.service.IBookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetailServiceImpl implements IBookDetailService {

    @Autowired
    private IBookDetailRepository iBookDetailRepository;


    @Override
    public List<BookDetail> findAll() {
        return iBookDetailRepository.findAll();
    }

    @Override
    public BookDetail findById(int id) {
        return iBookDetailRepository.findById(id);
    }

    @Override
    public void save(BookDetail bookDetail) {
        iBookDetailRepository.save(bookDetail);
    }
}
