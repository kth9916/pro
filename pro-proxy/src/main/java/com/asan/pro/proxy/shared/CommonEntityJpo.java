package com.asan.pro.proxy.shared;

import com.asan.pro.domain.shared.CommonEntity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class CommonEntityJpo {
    //
    @Id
    protected String id;
    @Version
    protected long entityVersion;

    @CreatedDate
    private LocalDateTime registeredOn;

    @CreatedBy
    private String registeredBy;

    @LastModifiedDate
    private LocalDateTime modifiedOn;

    @LastModifiedBy
    private String modifiedBy;

    protected CommonEntityJpo(CommonEntity commonEntity) {
        //
        this.id = commonEntity.getId();
        this.entityVersion = commonEntity.getEntityVersion();
        this.registeredOn = commonEntity.getRegisteredOn();
        this.registeredBy = commonEntity.getRegisteredBy();
        this.modifiedOn = commonEntity.getModifiedOn();
        this.modifiedBy = commonEntity.getModifiedBy();
    }

    protected CommonEntityJpo(String id) {
        this.id = id;
        this.entityVersion = 0L;
    }
}
