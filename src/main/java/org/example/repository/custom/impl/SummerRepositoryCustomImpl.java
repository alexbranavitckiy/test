package org.example.repository.custom.impl;

import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class SummerRepositoryCustomImpl {

    @PersistenceContext
    private Session entityManager;
}
