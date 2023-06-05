package org.example.services.persistsimpl;

import org.example.dto.AuthoritiesDTO;
import org.example.entiry.Authorities;
import org.example.repository.AuthoritiesRepository;
import org.example.repository.custom.AuthoritiesRepositoryCustom;
import org.example.services.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {


    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    public List<Authorities> getAll() {
        return authoritiesRepository.getAll();
    }

    public AuthoritiesDTO add(AuthoritiesDTO client) {//TODO
        return AuthoritiesDTO.fromAuthoritiesDTO(authoritiesRepository.save(client.tAuthoritiesDTO()));
    }

    public boolean remove(AuthoritiesDTO authorities) {//TODO
        ((AuthoritiesRepositoryCustom) authoritiesRepository).delete(authorities.tAuthoritiesDTO());
        return true;
    }

    public AuthoritiesDTO update(AuthoritiesDTO client) {//TODO
        authoritiesRepository.save(client.tAuthoritiesDTO());
        return client;
    }

}
