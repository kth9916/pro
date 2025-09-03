package com.asan.pro.facade.feature.user.rest;

import com.asan.pro.domain.user.domain.entity.sdo.UserCdo;
import com.asan.pro.facade.feature.user.command.RegisterUserCommand;
import com.asan.pro.feature.user.flow.UserFlow;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feature/user")
@RequiredArgsConstructor
public class UserFlowResource implements UserFlowFacade{
    private final UserFlow userFlow;

    @Override
    @PostMapping("/register")
    public void regiseterUser(RegisterUserCommand command) {
        UserCdo userCdo = command.getUserCdo();
        userFlow.registerUser(userCdo);
    }
}
