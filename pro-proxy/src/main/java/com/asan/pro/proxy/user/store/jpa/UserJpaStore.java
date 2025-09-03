package com.asan.pro.proxy.user.store.jpa;

import com.asan.pro.domain.user.domain.entity.User;
import com.asan.pro.domain.user.store.UserStore;
import com.asan.pro.proxy.user.store.jpa.jpo.UserJpo;
import com.asan.pro.proxy.user.store.jpa.repository.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserJpaStore implements UserStore {
    //
    private final UserJpaRepository userJpaRepository;

    public UserJpaStore(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    @Override
    public void create(User user) {
        UserJpo userJpo = new UserJpo(user);
        userJpaRepository.save(userJpo);
    }

    @Override
    public User retrieve(String id) {
        Optional<UserJpo> userJpo = userJpaRepository.findById(id);
        return userJpo.map(UserJpo::toDomain).orElse(null);
    }

    @Override
    public void update(User user) {
        UserJpo userJpo = new UserJpo(user);
        userJpaRepository.save(userJpo);
    }

    @Override
    public void delete(String id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        return userJpaRepository.existsById(id);
    }
}
