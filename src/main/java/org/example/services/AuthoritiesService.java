package org.example.services;

import org.example.dto.AuthoritiesDTO;
import org.example.entiry.Authorities;
import org.example.entiry.Owner;

import java.util.List;

public interface AuthoritiesService {


    List<Authorities> getAll() ;
    AuthoritiesDTO add(AuthoritiesDTO client);
    boolean remove(AuthoritiesDTO client);
    AuthoritiesDTO update(AuthoritiesDTO client);




}
