package com.asan.pro.feature.user.flow;

import com.asan.pro.domain.auth.domain.service.KeycloakSyncService;
import com.asan.pro.domain.user.domain.entity.User;
import com.asan.pro.domain.user.domain.entity.sdo.UserCdo;
import com.asan.pro.domain.user.domain.logic.UserLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserFlow {
    private final UserLogic userLogic;
    private final KeycloakSyncService keycloakSyncService;

    public User registerUser(UserCdo userCdo) {
        //
        String id = userLogic.registerUser(userCdo);
        User user = userLogic.findUser(id);

        // Keycloak 동기화
        keycloakSyncService.syncUser(user, user.getPassword());

        return user;
    }
}
