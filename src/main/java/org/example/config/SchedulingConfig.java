package org.example.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDTO;
import org.example.entiry.*;
import org.example.mapper.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@Slf4j
@EnableAsync
@EnableScheduling
public class SchedulingConfig {

    @PersistenceContext
    private EntityManager entityManager;
    private final CriteriaBuilder cb;

    private final MapperService<UserP, UserDTO> mapperService;

    @Autowired
    public SchedulingConfig(EntityManager entityManager, MapperService<UserP, UserDTO> mapperService) {
        this.mapperService = mapperService;
        this.entityManager = entityManager;
        this.cb = entityManager.getCriteriaBuilder();
    }

    @Async
    @Scheduled(fixedRate = 1)
    protected void SchedulingTest2() {

        //  System.out.println(entityManager.find(Authorities.class, 2L));

        // entityManager.persist();
    }


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