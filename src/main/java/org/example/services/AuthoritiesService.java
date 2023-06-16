package org.example.services;

import org.example.dto.AuthoritiesDTO;
import org.example.entiry.Authorities;
import org.example.entiry.Owner;
import org.example.error.NotFoundError;

import java.util.List;

public interface AuthoritiesService {


    List<AuthoritiesDTO> getAll() ;
    AuthoritiesDTO add(String code);
    boolean remove(Long id,String code);
    AuthoritiesDTO updateCodeIfExistId(AuthoritiesDTO authoritiesDTO) throws NotFoundError;




}
