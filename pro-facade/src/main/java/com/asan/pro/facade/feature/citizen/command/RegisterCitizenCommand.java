package com.asan.pro.facade.feature.citizen.command;

import com.asan.pro.domain.shared.JsonSerializable;
import com.asan.pro.domain.citizen.domain.entity.sdo.CitizenCdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCitizenCommand implements JsonSerializable {
    //
    private CitizenCdo citizenCdo;
    private String password;
}
