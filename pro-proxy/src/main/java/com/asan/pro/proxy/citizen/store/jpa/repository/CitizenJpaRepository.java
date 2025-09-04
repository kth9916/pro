package com.asan.pro.proxy.citizen.store.jpa.repository;

import com.asan.pro.proxy.citizen.store.jpa.jpo.CitizenJpo;
import org.springframework.data.jpa.repository.JpaRepository; // Added import


public interface CitizenJpaRepository extends JpaRepository<CitizenJpo, String> { // Added extends
    // UserRepository 인터페이스 구현

}
