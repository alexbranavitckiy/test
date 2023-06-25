package org.example.repository.customRepository.impl;

import jakarta.persistence.PersistenceContext;
import org.example.repository.customRepository.OwnerRepositoryCustom;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerRepositoryCustomImpl implements OwnerRepositoryCustom {

    @PersistenceContext
    private Session entityManager;
}
