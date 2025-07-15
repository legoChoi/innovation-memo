package com.innovation.spring.entry.memo.lv02.repository;

import com.innovation.spring.entry.memo.lv02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
