package com.ung_dung_thu_vien.service;


import com.ung_dung_thu_vien.model.BookDetail;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookDetailService {


    List<BookDetail> findAll();


    BookDetail findById(@Param("id") int id);

    void save(BookDetail bookDetail);
}
