package org.example.services.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.checkerframework.checker.units.qual.A;
import org.example.dto.AuthoritiesDTO;
import org.example.dto.OwnerDTO;
import org.example.entiry.Authorities;
import org.example.entiry.Owner;
import org.example.entiry.Owner_;
import org.example.mapper.MapperService;
import org.example.mapper.impl.OwnerModelMapperServiceImpl;
import org.example.repository.OwnerRepository;
import org.example.repository.SpecificationCustom.OwnerSpecification;
import org.example.services.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServicesImpl implements OwnerService {


    private final OwnerRepository ownerRepository;
    private final MapperService<Owner, OwnerDTO> mapperService;
    @PersistenceContext
    private EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;


    @Autowired
    public OwnerServicesImpl(OwnerRepository clientRepository, MapperService<Owner, OwnerDTO> mapperService, EntityManager entityManager) {
        this.ownerRepository = clientRepository;
        this.mapperService = mapperService;
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    @Override
    public List<OwnerDTO> getAll() {
        return ownerRepository.findAllBy().stream().map(mapperService::toDTO).collect(Collectors.toList());
    }

    @Override
    public OwnerDTO add(OwnerDTO client) {
        return null;
    }

    @Override
    public boolean remove(OwnerDTO client) {
        return false;
    }

    @Override
    public OwnerDTO update(OwnerDTO client) {
        return null;
    }

    @Override
    public List<OwnerDTO> test(OwnerDTO client) {
//        CriteriaQuery<Owner> criteriaQuery = criteriaBuilder.createQuery(Owner.class);
//        Root<Owner> root = criteriaQuery.from(Owner.class);
//
//        criteriaQuery
//                .select(root)
//                .where(criteriaBuilder.gt(root.get(Owner_.ID), 77));
//
//        return entityManager.createQuery(criteriaQuery)
//                .getResultList()
//                .stream()
//                .map(x -> mapperService.toDTO(x))
//                .collect(Collectors.toList());


        return ownerRepository
                .findAll(OwnerSpecification.hasOwnerPHONE(client.getPhone())).stream().map(mapperService::toDTO)
                .collect(Collectors.toList());
    }

}
