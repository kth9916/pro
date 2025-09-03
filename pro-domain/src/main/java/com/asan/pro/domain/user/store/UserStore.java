package com.asan.pro.domain.user.store;

import com.asan.pro.domain.user.domain.entity.User;

public interface UserStore {
    void create(User user);
    User retrieve(String id);
    void update(User user);
    void delete(String id);
    boolean exists(String id);
}
