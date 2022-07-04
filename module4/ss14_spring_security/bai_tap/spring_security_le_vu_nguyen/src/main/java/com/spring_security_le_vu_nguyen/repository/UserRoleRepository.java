package com.spring_security_le_vu_nguyen.repository;

import com.spring_security_le_vu_nguyen.entity.AppUser;
import com.spring_security_le_vu_nguyen.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
