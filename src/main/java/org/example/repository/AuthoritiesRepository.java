package org.example.repository;

import org.example.entiry.Authorities;
import org.example.repository.customRepository.AuthoritiesRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthoritiesRepository extends AuthoritiesRepositoryCustom, JpaRepository<Authorities, Long> {

    List<Authorities> findAllBy();

    @Modifying
    @Query(value = "update Authorities set close = :newValue where id = :id   and code = :code", nativeQuery = false)
    int updateStatusOnClose(@Param("id") Long id, @Param("code") String code, @Param("newValue") boolean newValue);



}
