package org.example.repository.customRepository;

import org.example.entiry.protection.Authorities;
import org.example.error.NotFoundError;

public interface AuthoritiesRepositoryCustom {

    Authorities update(Authorities entity);

    Authorities addAuthorities(Authorities code);

    Authorities updateCodeAndCloseValueIfExistId(Authorities build) throws NotFoundError;



}
