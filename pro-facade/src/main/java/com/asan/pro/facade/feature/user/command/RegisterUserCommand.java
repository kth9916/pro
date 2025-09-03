package com.asan.pro.facade.feature.user.command;

import com.asan.pro.domain.shared.JsonSerializable;
import com.asan.pro.domain.user.domain.entity.sdo.UserCdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserCommand implements JsonSerializable {
    //
    private UserCdo userCdo;
}
