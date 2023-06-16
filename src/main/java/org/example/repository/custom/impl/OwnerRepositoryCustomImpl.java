package org.example.repository.custom.impl;

import jakarta.persistence.PersistenceContext;
import org.example.repository.custom.OwnerRepositoryCustom;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class OwnerRepositoryCustomImpl implements OwnerRepositoryCustom {

    @PersistenceContext
    private Session entityManager;
}
