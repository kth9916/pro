package com.asan.pro.proxy.auth;

import com.asan.pro.domain.auth.domain.service.KeycloakSyncService;
import com.asan.pro.domain.citizen.domain.entity.Citizen;
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
    public void syncUser(Citizen citizen, String password) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(citizen.getLoginId());
        userRepresentation.setEmail(citizen.getEmail());
        userRepresentation.setLastName(citizen.getLastName());
        userRepresentation.setFirstName(citizen.getFirstName());
        userRepresentation.setEnabled(true);

        Response response = keycloak.realm(realm).users().create(userRepresentation);
        String cloakUserId = CreatedResponseUtil.getCreatedId(response);

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(password);

        keycloak.realm(realm).users().get(cloakUserId).resetPassword(passwordCred);
    }
}
