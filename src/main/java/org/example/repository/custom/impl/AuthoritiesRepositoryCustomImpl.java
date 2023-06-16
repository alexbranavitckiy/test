package org.example.repository.custom.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.example.entiry.Authorities;
import org.example.entiry.Authorities_;
import org.example.entiry.Owner;
import org.example.error.NotFoundError;
import org.example.repository.custom.AuthoritiesRepositoryCustom;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.List;

@Component
public class AuthoritiesRepositoryCustomImpl implements AuthoritiesRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Authorities update(Authorities entity) {
        return null;
    }

    @Override
    @Transactional
    public Authorities addAuthorities(Authorities code) {
        entityManager.persist(code);
        return code;
    }

    @Override
    @Transactional
    public Authorities updateCodeAndCloseValueIfExistId(Authorities build) throws NotFoundError {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Authorities> cq = cb.createQuery(Authorities.class);

        Root<Authorities> root = cq.from(Authorities.class);

        cq.select(root);

        cq.where(cb.equal(root.get(Authorities_.ID),
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

    @Override
    public Authorities updateCodeAndCloseValueIfExistIdQ(Authorities build) throws NotFoundError {
        return null;
    }

}
