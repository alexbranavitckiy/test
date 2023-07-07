package org.example.repository.customRepository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.example.entiry.protection.Authorities;
import org.example.error.NotFoundError;
import org.example.repository.customRepository.AuthoritiesRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthoritiesRepositoryCustomImpl implements AuthoritiesRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;
    private final CriteriaBuilder cb;

    @Autowired
    public AuthoritiesRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.cb = entityManager.getCriteriaBuilder();
    }

    @Override
    public Authorities update(Authorities entity) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Authorities addAuthorities(Authorities code) {
        entityManager.persist(code);
        return code;
    }

    @Override
    @Transactional
    public Authorities updateCodeAndCloseValueIfExistId(Authorities build) throws NotFoundError {

        CriteriaQuery<Authorities> cq = cb.createQuery(Authorities.class);

        Root<Authorities> root = cq.from(Authorities.class);

        cq.select(root);

        cq.where(cb.equal(root.get("ID"),
                build.getId()));

        cq.orderBy(cb.desc(root.get("id")));

        List<Authorities> resultList = entityManager.createQuery(cq).getResultList();

        if (!resultList.isEmpty()) {
            entityManager.merge(build);
            entityManager.flush();
        } else {
            throw new NotFoundError("Entity not found");
        }

        return build;
    }


}
