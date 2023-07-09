package org.example.repository;


import org.example.entiry.UserP;
import org.example.repository.customRepository.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends UserRepositoryCustom, JpaRepository<UserP, Long>, JpaSpecificationExecutor<UserP> {


}
