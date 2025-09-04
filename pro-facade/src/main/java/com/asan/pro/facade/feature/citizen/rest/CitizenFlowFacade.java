package com.asan.pro.facade.feature.citizen.rest;

import com.asan.pro.facade.feature.citizen.command.RegisterCitizenCommand;

public interface CitizenFlowFacade {
    //
    void regiseterCitizen(RegisterCitizenCommand command);
}
