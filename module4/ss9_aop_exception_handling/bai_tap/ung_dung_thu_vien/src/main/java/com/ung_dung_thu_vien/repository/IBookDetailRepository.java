package com.ung_dung_thu_vien.repository;

import com.ung_dung_thu_vien.model.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IBookDetailRepository extends JpaRepository<BookDetail,Integer> {
    @Query(value = "select * from book_detail",nativeQuery = true)
    List<BookDetail> findAll();

    @Query(value = "select * from book_detail where id = :id",nativeQuery = true)
    BookDetail findById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = " update book_detail set status = 1 ",nativeQuery = true)
    void borrowBook();

    @Modifying
    @Transactional
    @Query(value = " update book_detail set status = 0 ",nativeQuery = true)
    void giveBookBack();
}
