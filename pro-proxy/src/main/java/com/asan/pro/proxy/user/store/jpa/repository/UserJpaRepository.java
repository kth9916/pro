package com.asan.pro.proxy.user.store.jpa.repository;

import com.asan.pro.proxy.user.store.jpa.jpo.UserJpo;
import org.springframework.data.jpa.repository.JpaRepository; // Added import


public interface UserJpaRepository extends JpaRepository<UserJpo, String> { // Added extends
    // UserRepository 인터페이스 구현

}
