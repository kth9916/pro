package com.asan.pro.domain.user.domain.entity;

import com.asan.pro.domain.shared.CommonEntity;
import com.asan.pro.domain.user.domain.entity.sdo.UserCdo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class User extends CommonEntity {

    private String userId;
    private String password;
    private String lastName;
    private String firstName;
    private String email;

    public User(String id) {
        //
        super(id);
    }

    public User(UserCdo userCdo) {
        super();
        this.userId = userCdo.getUserId();
        this.password = userCdo.getPassword();
        this.lastName = userCdo.getLastName();
        this.firstName = userCdo.getFirstName();
        this.email = userCdo.getEmail();
    }
}
