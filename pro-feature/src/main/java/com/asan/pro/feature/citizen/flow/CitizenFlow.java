package com.asan.pro.feature.citizen.flow;

import com.asan.pro.domain.auth.domain.service.KeycloakSyncService;
import com.asan.pro.domain.citizen.domain.entity.Citizen;
import com.asan.pro.domain.citizen.domain.entity.sdo.CitizenCdo;
import com.asan.pro.domain.citizen.domain.logic.CitizenLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CitizenFlow {
    private final CitizenLogic citizenLogic;
    private final KeycloakSyncService keycloakSyncService;

    public Citizen registerUser(CitizenCdo citizenCdo, String password) {
        //
        String id = citizenLogic.registerCitizen(citizenCdo);
        Citizen citizen = citizenLogic.findUser(id);

        // Keycloak 동기화
        keycloakSyncService.syncUser(citizen, password);

        return citizen;
    }
}
