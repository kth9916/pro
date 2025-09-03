package com.asan.pro.feature.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRegistrationRequest {
    private final String username;
    private final String email;
    private final String password;
}
