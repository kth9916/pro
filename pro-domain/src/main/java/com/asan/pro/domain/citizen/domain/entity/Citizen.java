package com.asan.pro.domain.citizen.domain.entity;

import com.asan.pro.domain.shared.CommonEntity;
import com.asan.pro.domain.citizen.domain.entity.sdo.CitizenCdo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Citizen extends CommonEntity {

    private String loginId;
    private String lastName;
    private String firstName;
    private String email;

    public Citizen(String id) {
        //
        super(id);
    }

    public Citizen(CitizenCdo citizenCdo) {
        super();
        this.loginId = citizenCdo.getLoginId();
        this.lastName = citizenCdo.getLastName();
        this.firstName = citizenCdo.getFirstName();
        this.email = citizenCdo.getEmail();
    }
}
