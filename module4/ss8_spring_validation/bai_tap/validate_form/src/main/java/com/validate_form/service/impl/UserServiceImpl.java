package com.validate_form.service.impl;

import com.validate_form.model.User;
import com.validate_form.repository.IUserRepository;
import com.validate_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public List<User> findById(int id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        iUserRepository.remove(id);
    }

    @Override
    public Page<User> findAllByName(String name, Pageable pageable) {
        return iUserRepository.findAllByName(name,pageable);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
