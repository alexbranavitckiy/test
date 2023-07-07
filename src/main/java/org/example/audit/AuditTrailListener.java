package org.example.audit;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.example.entiry.protection.Authorities;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuditTrailListener {


    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Authorities o) {
        if (o == null) {
            log.info("[USER AUDIT] About to add a user");
        } else {
            log.info("[USER AUDIT] About to update/delete user: " );
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Authorities o) {
        log.info("[USER AUDIT] add/update/delete complete for user: ");
    }

    @PostLoad
    private void afterLoad(Authorities o) {
        //   log.info("[USER AUDIT] user loaded from database: ");
    }

}
