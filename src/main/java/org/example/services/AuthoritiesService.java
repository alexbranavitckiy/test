package org.example.services;

import org.example.dto.AuthoritiesDTO;
import org.example.entiry.protection.Authorities;
import org.example.error.NotFoundError;

import java.util.List;

public interface AuthoritiesService {

    List<Authorities> getAll();

    Authorities add(String code);

    void remove(Long id, String code);

    Authorities update(AuthoritiesDTO authoritiesDTO) throws NotFoundError;


}
