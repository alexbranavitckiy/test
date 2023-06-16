package org.example.repository.custom;

import org.example.entiry.Authorities;
import org.example.error.NotFoundError;

public interface AuthoritiesRepositoryCustom {

    Authorities update(Authorities entity);

    Authorities addAuthorities(Authorities code);

    Authorities updateCodeAndCloseValueIfExistId(Authorities build) throws NotFoundError;


    Authorities updateCodeAndCloseValueIfExistIdQ(Authorities build) throws NotFoundError;

}
