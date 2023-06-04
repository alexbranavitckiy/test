package org.example.audit;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.example.entiry.Owner;

@Slf4j
public class AuditTrailListener {


    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Owner user) {
        if (user.getId()!=null) {
          log.info("[USER AUDIT] About to add a user:"+ user.getId());
        } else {
            log.info("[USER AUDIT] About to update/delete user: " );
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Owner user) {
        log.info("[USER AUDIT] add/update/delete complete for user: " + user.getId());
    }

    @PostLoad
    private void afterLoad(Owner user) {
        log.info("[USER AUDIT] user loaded from database: " + user.getId());
    }

}
