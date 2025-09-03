package com.asan.pro.facade.feature.user.rest;

import com.asan.pro.domain.user.domain.entity.sdo.UserCdo;
import com.asan.pro.facade.feature.user.command.RegisterUserCommand;
import com.asan.pro.feature.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feature/user")
@RequiredArgsConstructor
public class UserFlowResource implements UserFlowFacade{
    private final UserService userService;

    @Override
    @PostMapping("/register")
    public void regiseterUser(RegisterUserCommand command) {
        UserCdo userCdo = command.getUserCdo();
        userService.registerUser(userCdo);
    }
}
