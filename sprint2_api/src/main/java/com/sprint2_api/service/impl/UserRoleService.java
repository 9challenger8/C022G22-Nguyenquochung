package com.sprint2_api.service.impl;


import com.sprint2_api.model.UserRole;
import com.sprint2_api.repository.UserRepository;
import com.sprint2_api.repository.UserRoleRepository;
import com.sprint2_api.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }


    @Override
    public void save(UserRole userRole) {
        userRoleRepository.save(userRole.getAppRole().getId(), userRole.getAppUser().getId());
    }


    @Override
    public void deleteUserRole(int id) {
        userRoleRepository.deleteUserRole(id);
    }
}
