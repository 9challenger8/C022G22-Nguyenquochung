package com.validate_form.repository;

import com.validate_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from user",nativeQuery = true)
    List<User> findAll();

    @Query(value = "select * from user where id= :id",nativeQuery = true)
    List<User> findById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from user where id =:id",nativeQuery = true)
    void remove(@Param("id") int id);


    @Query(value = "select * from user where first_name like :name",nativeQuery = true,
    countQuery = "select count (*) from (select * from user where first_name like :name) abc ")
    Page<User> findAllByName(String name, Pageable pageable);


}
