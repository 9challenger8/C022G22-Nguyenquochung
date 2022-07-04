package com.spring_security_le_vu_nguyen.repository;

import com.spring_security_le_vu_nguyen.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String username);
}
