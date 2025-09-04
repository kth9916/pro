package com.asan.pro.facade.feature.citizen.rest;

import com.asan.pro.domain.citizen.domain.entity.sdo.CitizenCdo;
import com.asan.pro.facade.feature.citizen.command.RegisterCitizenCommand;
import com.asan.pro.feature.citizen.flow.CitizenFlow;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feature/citizen")
@RequiredArgsConstructor
public class CitizenFlowResource implements CitizenFlowFacade {
    private final CitizenFlow citizenFlow;

    @Override
    @PostMapping("/register")
    public void regiseterCitizen(RegisterCitizenCommand command) {
        CitizenCdo citizenCdo = command.getCitizenCdo();
        String password = command.getPassword();
        citizenFlow.registerUser(citizenCdo, password);
    }
}
