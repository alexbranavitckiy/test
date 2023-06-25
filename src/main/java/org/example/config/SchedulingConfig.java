package org.example.config;

import com.jayway.jsonpath.Criteria;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.OwnerDTO;
import org.example.entiry.*;
import org.example.error.NotFoundError;
import org.example.mapper.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.stream.Collectors;

@Configuration
@Slf4j
@EnableAsync
@EnableScheduling
public class SchedulingConfig {

    @PersistenceContext
    private EntityManager entityManager;
    private final CriteriaBuilder cb;

    private final MapperService<Owner, OwnerDTO> mapperService;

    @Autowired
    public SchedulingConfig(EntityManager entityManager, MapperService<Owner, OwnerDTO> mapperService) {
        this.mapperService = mapperService;
        this.entityManager = entityManager;
        this.cb = entityManager.getCriteriaBuilder();
    }

//    @Async
//    @Scheduled(fixedRate = 1)
//    protected void SchedulingTest2() {
//
//        CriteriaQuery<Summer> criteriaQuery = cb.createQuery(Summer.class);
//        Root<Summer> root = criteriaQuery.from(Summer.class);
//
//        EntityGraph<?> entityGraph = entityManager.getEntityGraph("graph.Summer.client.authorities");
//
//
//        //  root.fetch(Authorities_.owners, JoinType.INNER);
//
//        // criteriaQuery
//        //         .select(root);
//
//        TypedQuery<Summer> typedQuery = entityManager.createQuery(criteriaQuery);
//
//        typedQuery.setHint("javax.persistence.fetchgraph", entityGraph);
//
//        typedQuery.getResultList();
//
//
//    }


//    @Async
//    @Scheduled(fixedRate = 9000)
//    protected void SchedulingTest() {
//
//        CriteriaQuery<Owner> criteriaQuery = cb.createQuery(Owner.class);
//        Root<Owner> root = criteriaQuery.from(Owner.class);
//
//
//        root.fetch(Owner_.AUTHORITIES, JoinType.INNER);
//
//        cb.equal(root.get(Owner_.LAST_NAME), "12");
//
//        criteriaQuery
//                .select(root)
//                .where(cb.gt(root.get(Owner_.ID), 77)).orderBy(cb.asc(root.get(Owner_.AUTHORITIES)));
//
//
//        System.out.println(entityManager.createQuery(criteriaQuery)
//                .getResultList()
//                .stream()
//                .map(mapperService::toDTO)
//                .collect(Collectors.toList()));
//
//
//    }
}