package org.example.repository.customRepository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.repository.customRepository.SummerRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SummerRepositoryCustomImpl implements SummerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    private final CriteriaBuilder cb;

    @Autowired
    public SummerRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.cb = entityManager.getCriteriaBuilder();
    }



}
