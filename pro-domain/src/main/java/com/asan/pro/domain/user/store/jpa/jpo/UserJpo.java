package com.asan.pro.domain.user.store.jpa.jpo;

import com.asan.pro.domain.shared.CommonEntityJpo;
import com.asan.pro.domain.user.domain.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "user") // 테이블명은 일반적으로 복수형
@Getter
@Setter
@NoArgsConstructor
public class UserJpo extends CommonEntityJpo {

    private String userId;
    private String password;
    private String username;
    private String email;

    public UserJpo(User user) {
        super(user);
        BeanUtils.copyProperties(user, this);
    }

    public User toDomain() {
        /* Gen by NARA Studio */
        User user = new User(getId());
        BeanUtils.copyProperties(this, user);
        return user;
    }
    public static List<User> toDomains(List<UserJpo> userJpos) {
        return userJpos.stream().map(UserJpo::toDomain).collect(Collectors.toList());
    }
}
