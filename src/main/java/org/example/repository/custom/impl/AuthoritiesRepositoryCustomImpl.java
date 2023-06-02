package org.example.repository.custom.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.example.entiry.Authorities;
import org.example.entiry.Authorities_;
import org.example.repository.custom.AuthoritiesRepositoryCustom;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;

@Component
public class AuthoritiesRepositoryCustomImpl implements AuthoritiesRepositoryCustom {


    @PersistenceContext
    private Session entityManager;


    public List<Authorities> getAll() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Authorities> cq = cb.createQuery(Authorities.class);

        Root<Authorities> root = cq.from(Authorities.class);

        Selection[] authoritiesSelection = {root.get(Authorities_.CODE).alias(Authorities_.CODE)
                , root.get(Authorities_.id).alias(Authorities_.ID)};

        ParameterExpression<String> parameterExpression = cb.parameter(String.class, "name");

        cq.select(cb.construct(Authorities.class, authoritiesSelection)).where(cb.like(root.get(Authorities_.CODE), parameterExpression));

        return entityManager.createQuery(cq).setParameter("name", "%").getResultList();

    }

    @Transactional
    public void delete(Authorities authorities) {

        Authorities authorities1=  entityManager.get(Authorities.class,authorities.getId());

        entityManager.remove(authorities1);


    }

}
