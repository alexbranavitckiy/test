package org.example.repository;


import org.example.entiry.Summer;
import org.example.repository.customRepository.SummerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummerRepository extends SummerRepositoryCustom, JpaRepository<Summer, Long> {
}
