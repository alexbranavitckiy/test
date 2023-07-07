package org.example.services.Impl;

import org.example.dto.AuthoritiesDTO;
import org.example.entiry.protection.Authorities;
import org.example.error.NotFoundError;
import org.example.mapper.MapperService;
import org.example.repository.AuthoritiesRepository;
import org.example.services.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {


    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private MapperService<Authorities, AuthoritiesDTO> mapperServiceHolder;

    @Override
    public List<Authorities> getAll() {
        return null;
    }

    @Override
    public Authorities add(String code) {
        return null;
    }

    @Override
    public void remove(Long id, String code) {
    }

    @Override
    public Authorities update(AuthoritiesDTO authoritiesDTO) throws NotFoundError {
        return null;
    }
}
