package com.validate_form.service;

import com.validate_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    List<User> findById(@Param("id") int id);

    void remove(@Param("id") int id);

    Page<User> findAllByName(String name, Pageable pageable);

    void save(User user);
}
