package com.asan.pro.domain.user.domain.entity.sdo;

import com.asan.pro.domain.shared.JsonSerializable;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCdo implements JsonSerializable {
    //
    private String userId;
    private String password;
    private String username;
    private String email;
}
