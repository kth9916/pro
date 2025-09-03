package com.asan.pro.domain.user.domain.logic;

import com.asan.pro.domain.user.domain.entity.User;
import com.asan.pro.domain.user.domain.entity.sdo.UserCdo;
import com.asan.pro.domain.user.store.UserStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserLogic {
    private final UserStore userStore;

    public UserLogic(UserStore userStore) {
        this.userStore = userStore;
    }

    public String registerUser(UserCdo userCdo) {
        //
        User user = new User(userCdo);
        if (userStore.exists(user.getId())) {
            throw new IllegalArgumentException("user already exists. " + user.getId());
        }
        userStore.create(user);
        return user.getId();
    }

    public User findUser(String id) {
        return userStore.retrieve(id);
    }

}
