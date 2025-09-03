package com.asan.pro.facade.feature.user.rest;

import com.asan.pro.facade.feature.user.command.RegisterUserCommand;

public interface UserFlowFacade {
    //
    void regiseterUser(RegisterUserCommand command);
}
