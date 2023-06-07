package org.example.services.impl;

import org.example.dto.AuthoritiesDTO;
import org.example.mapper.MapperServiceHolder;
import org.example.repository.AuthoritiesRepository;
import org.example.services.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {


    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private MapperServiceHolder mapperServiceHolder;

    @Override
    public List<AuthoritiesDTO> getAll() {
        var mapper=mapperServiceHolder.getMapperService("Authorities");
        return authoritiesRepository.getAll().stream().map(x ->mapper.toDTO(x)).collect(Collectors.toList());
    }

    @Override
    public AuthoritiesDTO add(String code) {
        return null;
    }

    @Override
    public boolean remove(Long id, String code) {
        return false;
    }

    @Override
    public AuthoritiesDTO update(Long id, String code) {
        return null;
    }

}
