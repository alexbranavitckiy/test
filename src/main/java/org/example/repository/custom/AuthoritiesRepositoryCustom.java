package org.example.repository.custom;

import org.example.entiry.Authorities;

import java.util.List;

public interface AuthoritiesRepositoryCustom {


     List<Authorities> getAll();

    void delete(Authorities entity);


}
