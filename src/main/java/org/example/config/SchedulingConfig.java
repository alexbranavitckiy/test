package org.example.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.OwnerDTO;
import org.example.entiry.Authorities;
import org.example.entiry.Owner;
import org.example.entiry.Owner_;
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

    @Async
    @Scheduled(fixedRate = 9000)
    protected void SchedulingTest() {

        CriteriaQuery<Owner> criteriaQuery = cb.createQuery(Owner.class);
        Root<Owner> root = criteriaQuery.from(Owner.class);


        root.fetch(Owner_.AUTHORITIES, JoinType.INNER);

        criteriaQuery
                .select(root)
                .where(cb.gt(root.get(Owner_.ID), 77));


        System.out.println(entityManager.createQuery(criteriaQuery)
                .getResultList()
                .stream()
                .map(mapperService::toDTO)
                .collect(Collectors.toList()));


    }


}