package org.example.services.Impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.dto.UserDTO;
import org.example.entiry.UserP;
import org.example.mapper.MapperService;
import org.example.repository.UserRepository;
import org.example.repository.SpecificationCustom.PeopleSpecification;
import org.example.services.UserService;
import org.example.services.UserInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserService {


    private final UserRepository ownerRepository;
    private final MapperService<UserP, UserDTO> mapperService;
    @PersistenceContext
    private EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;
    private final Map<String, UserInit> ownerInitMap;


    @Autowired
    public UserServicesImpl(Map<String, UserInit> ownerInitMap, UserRepository clientRepository, MapperService<UserP,
            UserDTO> mapperService, EntityManager entityManager) {
        this.ownerRepository = clientRepository;
        this.ownerInitMap = ownerInitMap;
        this.mapperService = mapperService;
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();

        System.out.println(ownerInitMap);

    }

    @Override
    public UserDTO add(UserDTO client) {
        return null;
    }

    @Override
    public List<UserP> getAllUsers(int page, int size, String sortBy, String search) {
        return null;
    }

    @Override
    public UserP createUser(UserP user) {
        return null;
    }

    @Override
    public UserP deleteUser(long id) {
        return null;
    }

    @Override
    public UserP updateUser(long id, UserP user) {
        return null;
    }

//    @Override
//    public UserDTO add(UserDTO client) {
//        return ownerInitMap.containsKey(client.getRole()) ?
//                ownerInitMap.get(client.getRole()).initOwner(client) :
//                ownerInitMap.get("DefaultOwnerService").initOwner(client);
//    }


//    @Override
//    public List<UserDTO> test(UserDTO client) {
//        return ownerRepository
//                .findAll(Specification.where(PeopleSpecification
//                        .hasOwnerPHONE(client.getPhone())
//                        .and(PeopleSpecification.hasOwnerPHONE(""))))
//                .stream().map(mapperService::toDTO)
//                .collect(Collectors.toList());
//    }

}
