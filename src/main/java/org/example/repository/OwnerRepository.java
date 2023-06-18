package org.example.repository;


import org.example.entiry.Owner;
import org.example.repository.customRepository.OwnerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends OwnerRepositoryCustom, JpaRepository<Owner, Long>, JpaSpecificationExecutor<Owner> {


    List<Owner> findAllBy();




}
