package com.asan.pro.proxy.citizen.store.jpa;

import com.asan.pro.domain.citizen.domain.entity.Citizen;
import com.asan.pro.domain.citizen.store.CitizenStore;
import com.asan.pro.proxy.citizen.store.jpa.jpo.CitizenJpo;
import com.asan.pro.proxy.citizen.store.jpa.repository.CitizenJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CitizenJpaStore implements CitizenStore {
    //
    private final CitizenJpaRepository citizenJpaRepository;

    public CitizenJpaStore(CitizenJpaRepository citizenJpaRepository) {
        this.citizenJpaRepository = citizenJpaRepository;
    }


    @Override
    public void create(Citizen citizen) {
        CitizenJpo citizenJpo = new CitizenJpo(citizen);
        citizenJpaRepository.save(citizenJpo);
    }

    @Override
    public Citizen retrieve(String id) {
        Optional<CitizenJpo> userJpo = citizenJpaRepository.findById(id);
        return userJpo.map(CitizenJpo::toDomain).orElse(null);
    }

    @Override
    public void update(Citizen citizen) {
        CitizenJpo citizenJpo = new CitizenJpo(citizen);
        citizenJpaRepository.save(citizenJpo);
    }

    @Override
    public void delete(String id) {
        citizenJpaRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        return citizenJpaRepository.existsById(id);
    }
}
