package com.asan.pro.domain.citizen.domain.logic;

import com.asan.pro.domain.citizen.domain.entity.Citizen;
import com.asan.pro.domain.citizen.domain.entity.sdo.CitizenCdo;
import com.asan.pro.domain.citizen.store.CitizenStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CitizenLogic {
    private final CitizenStore citizenStore;

    public CitizenLogic(CitizenStore citizenStore) {
        this.citizenStore = citizenStore;
    }

    public String registerCitizen(CitizenCdo citizenCdo) {
        //
        Citizen citizen = new Citizen(citizenCdo);
        if (citizenStore.exists(citizen.getId())) {
            throw new IllegalArgumentException("user already exists. " + citizen.getId());
        }
        citizenStore.create(citizen);
        return citizen.getId();
    }

    public Citizen findUser(String id) {
        return citizenStore.retrieve(id);
    }

}
