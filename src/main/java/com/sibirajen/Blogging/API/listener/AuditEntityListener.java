package com.sibirajen.Blogging.API.listener;

import com.sibirajen.Blogging.API.model.DateEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class AuditEntityListener {
    @PrePersist
    public void prePersist(DateEntity entity) {
        LocalDateTime now = LocalDateTime.now();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

    @PreUpdate
    public void preUpdate(DateEntity entity) {
        LocalDateTime now = LocalDateTime.now();
        entity.setUpdatedAt(now);
    }
}
