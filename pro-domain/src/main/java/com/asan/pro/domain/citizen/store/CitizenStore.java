package com.asan.pro.domain.citizen.store;

import com.asan.pro.domain.citizen.domain.entity.Citizen;

public interface CitizenStore {
    void create(Citizen citizen);
    Citizen retrieve(String id);
    void update(Citizen citizen);
    void delete(String id);
    boolean exists(String id);
}
