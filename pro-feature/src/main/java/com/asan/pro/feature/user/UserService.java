package com.asan.pro.feature.user;

import com.asan.pro.domain.user.domain.entity.User;
import com.asan.pro.domain.user.domain.entity.sdo.UserCdo;
import com.asan.pro.domain.user.domain.logic.UserLogic;
import com.asan.pro.proxy.auth.KeycloakSyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserLogic userLogic;
    private final KeycloakSyncService keycloakSyncService;

    @Transactional
    public User registerUser(UserCdo userCdo) {
        //
        String id = userLogic.registerUser(userCdo);
        User user = userLogic.findUser(id);

        // Keycloak 동기화
        keycloakSyncService.syncUser(user, user.getPassword());

        return user;
    }
}
