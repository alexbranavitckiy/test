package org.example.audit;

import jakarta.persistence.*;
import org.example.entiry.Owner;

public class AuditTrailListener {


    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Owner user) {
        if (user.getId() == 0) {
           System.out.println("[USER AUDIT] About to add a user");
        } else {
            System.out.println("[USER AUDIT] About to update/delete user: " + user.getId());
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Owner user) {
        System.out.println("[USER AUDIT] add/update/delete complete for user: " + user.getId());
    }

    @PostLoad
    private void afterLoad(Owner user) {
        System.out.println("[USER AUDIT] user loaded from database: " + user.getId());
    }

}
