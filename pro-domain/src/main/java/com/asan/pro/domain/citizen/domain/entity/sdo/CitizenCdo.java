package com.asan.pro.domain.citizen.domain.entity.sdo;

import com.asan.pro.domain.shared.JsonSerializable;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitizenCdo implements JsonSerializable {
    //
    private String loginId;
    private String lastName;
    private String firstName;
    private String email;
}
