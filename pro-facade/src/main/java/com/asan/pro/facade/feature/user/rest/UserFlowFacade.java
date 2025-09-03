package com.asan.pro.facade.feature.user.rest;

import com.asan.pro.facade.feature.user.command.RegisterUserCommand;
import com.asan.pro.feature.user.dto.UserRegistrationRequest;

public interface UserFlowFacade {
    //
    void regiseterUser(RegisterUserCommand command);
}
