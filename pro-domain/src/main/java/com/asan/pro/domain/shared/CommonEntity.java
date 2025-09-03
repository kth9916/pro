package com.asan.pro.domain.shared;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class CommonEntity implements JsonSerializable {
    //
    private String id;
    private long entityVersion;
    private LocalDateTime registeredOn;
    private String registeredBy;
    private LocalDateTime modifiedOn;
    private String modifiedBy;

    protected CommonEntity(String id) {
        //
        this();
        this.id = id;
    }
    protected CommonEntity() {
        this.id = UUID.randomUUID().toString();
        this.entityVersion = 0L;
    }
}
