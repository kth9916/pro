package com.asan.pro.proxy.auth;

import com.asan.pro.domain.user.domain.entity.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.CreatedResponseUtil;

@Service
public class KeycloakAdminClientServiceImpl implements KeycloakSyncService {

    private final Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String realm;

    public KeycloakAdminClientServiceImpl(Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    @Override
    public void syncUser(User user, String password) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(user.getUsername());
        userRepresentation.setEmail(user.getEmail());
        userRepresentation.setEnabled(true);

        Response response = keycloak.realm(realm).users().create(userRepresentation);
        String userId = CreatedResponseUtil.getCreatedId(response);

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(password);

        keycloak.realm(realm).users().get(userId).resetPassword(passwordCred);
    }
}
