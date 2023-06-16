package org.example.repository.custom.impl;

import jakarta.persistence.PersistenceContext;
import org.example.repository.custom.OwnerRepositoryCustom;
import org.example.repository.custom.SummerRepositoryCustom;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class SummerRepositoryCustomImpl implements SummerRepositoryCustom {

    @PersistenceContext
    private Session entityManager;
}
