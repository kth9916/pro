package com.asan.pro.domain.user.domain.entity;

import com.asan.pro.domain.shared.CommonEntity;
import com.asan.pro.domain.shared.CommonEntityJpo;
import com.asan.pro.domain.user.domain.entity.sdo.UserCdo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import lombok.*;

import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
public class User extends CommonEntity {

    private String userId;
    private String password;
    private String username;
    private String email;

    public User(String id) {
        //
        super(id);
    }

    public User(UserCdo userCdo) {
        super();
        this.userId = userCdo.getUserId();
        this.password = userCdo.getPassword();
        this.username = userCdo.getUsername();
        this.email = userCdo.getEmail();
    }
}
