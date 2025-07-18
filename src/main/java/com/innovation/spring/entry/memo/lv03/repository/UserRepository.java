package com.innovation.spring.entry.memo.lv03.repository;

import com.innovation.spring.entry.memo.lv03.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 요청된 email로 가입된 유저가 존재하는지 확인
     * @param email
     * @return boolean true or false
     */
    boolean existsByEmail(String email);

    /**
     * email로 유저 목록 검색
     * @param email
     * @return Optional<User> 해당 이메일의 유저 (없을 경우 empty)
     */
    Optional<User> findByEmail(String email);
}
