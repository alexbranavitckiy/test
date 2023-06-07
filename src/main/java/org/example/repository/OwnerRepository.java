package org.example.repository;


import org.example.entiry.Owner;
import org.example.repository.custom.OwnerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends OwnerRepositoryCustom, JpaRepository<Owner, Long> {
}
