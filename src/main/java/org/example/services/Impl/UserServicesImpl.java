package org.example.services.Impl;


import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

    private  CriteriaBuilder cb;
    private final CriteriaBuilder criteriaBuilder;
    private final Map<String, UserInit> ownerInitMap;

    @PostConstruct
    private void initializeCriteriaBuilder() {
        cb = entityManager.getCriteriaBuilder();
    }
    @Autowired
    public UserServicesImpl(Map<String, UserInit> ownerInitMap, UserRepository clientRepository, MapperService<UserP,
            UserDTO> mapperService, EntityManager entityManager) {
        this.ownerRepository = clientRepository;
        this.ownerInitMap = ownerInitMap;
        this.mapperService = mapperService;
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    @Override
    public UserDTO add(UserDTO client) {
        return null;
    }

    @Override
    public List<UserP> getAllUsers(int offset, int limit, String sortBy, String search) {

        CriteriaQuery<UserP> cq = cb.createQuery(UserP.class);
        Root<UserP> root = cq.from(UserP.class);
        cq.select(root).orderBy(cb.asc(root.get(search)));
        return entityManager.createQuery(cq).setFirstResult(offset).setMaxResults(limit).getResultList();

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


}
