package org.example.services.persistsimpl;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.dto.OwnerDTO;
import org.example.entiry.Owner;
import org.example.mapper.MapperService;
import org.example.repository.OwnerRepository;
import org.example.repository.SpecificationCustom.OwnerSpecification;
import org.example.services.OwnerService;
import org.example.services.ownerPack.OwnerInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OwnerServicesImpl implements OwnerService {


    private final OwnerRepository ownerRepository;
    private final MapperService<Owner, OwnerDTO> mapperService;
    @PersistenceContext
    private EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;
    private final Map<String, OwnerInit> ownerInitMap;


    @Autowired
    public OwnerServicesImpl(Map<String, OwnerInit> ownerInitMap, OwnerRepository clientRepository, MapperService<Owner, OwnerDTO> mapperService, EntityManager entityManager) {
        this.ownerRepository = clientRepository;
        this.ownerInitMap = ownerInitMap;
        this.mapperService = mapperService;
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();

        System.out.println(ownerInitMap);

    }

    @Override
    public List<OwnerDTO> getAll() {
        return ownerRepository.findAllBy().stream().map(mapperService::toDTO).collect(Collectors.toList());
    }

    @Override
    public OwnerDTO add(OwnerDTO client) {
        return ownerInitMap.containsKey(client.getRole()) ?
                ownerInitMap.get(client.getRole()).initOwner(client) :
                ownerInitMap.get("DefaultOwnerService").initOwner(client);
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
        return ownerRepository
                .findAll(Specification.where(OwnerSpecification.hasOwnerPHONE(client.getPhone()).and(OwnerSpecification.hasOwnerPHONE("")))).stream().map(mapperService::toDTO)
                .collect(Collectors.toList());
    }

}
