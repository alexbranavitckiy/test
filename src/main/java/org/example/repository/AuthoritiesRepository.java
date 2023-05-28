package org.example.repository;

import org.example.entiry.Authorities;
import org.example.repository.custom.AuthoritiesRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends AuthoritiesRepositoryCustom, JpaRepository<Authorities, Long> {
}
