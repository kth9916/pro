package com.asan.pro.proxy.citizen.store.jpa.jpo;

import com.asan.pro.domain.citizen.domain.entity.Citizen;
import com.asan.pro.proxy.shared.CommonEntityJpo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "citizen") // 테이블명은 일반적으로 복수형
@Getter
@Setter
@NoArgsConstructor
public class CitizenJpo extends CommonEntityJpo {

    private String accountId;
    private String lastName;
    private String firstName;
    private String email;

    public CitizenJpo(Citizen citizen) {
        super(citizen);
        BeanUtils.copyProperties(citizen, this);
    }

    public Citizen toDomain() {
        /* Gen by NARA Studio */
        Citizen citizen = new Citizen(getId());
        BeanUtils.copyProperties(this, citizen);
        return citizen;
    }
    public static List<Citizen> toDomains(List<CitizenJpo> citizenJpos) {
        return citizenJpos.stream().map(CitizenJpo::toDomain).collect(Collectors.toList());
    }
}
