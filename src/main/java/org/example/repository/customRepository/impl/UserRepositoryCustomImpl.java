package org.example.repository.customRepository.impl;

import jakarta.persistence.PersistenceContext;
import org.example.repository.customRepository.UserRepositoryCustom;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private Session entityManager;
}
