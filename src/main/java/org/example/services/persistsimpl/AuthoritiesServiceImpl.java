package org.example.services.impl;

import jakarta.transaction.Transactional;
import org.example.dto.AuthoritiesDTO;
import org.example.entiry.Authorities;
import org.example.error.NotFoundError;
import org.example.mapper.MapperService;
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
    private MapperService<Authorities, AuthoritiesDTO> mapperServiceHolder;

    @Override
    public List<AuthoritiesDTO> getAll() {
        return authoritiesRepository.findAllBy().stream().map(x -> mapperServiceHolder.toDTO(x)).collect(Collectors.toList());
    }

    @Override
    public AuthoritiesDTO add(String code) {
        return mapperServiceHolder.toDTO(authoritiesRepository.addAuthorities(Authorities.builder().code(code).build()));
    }

    @Override
    @Transactional
    public boolean remove(Long id, String code) {
        return authoritiesRepository.updateStatusOnClose(id, code, false) == 1;
    }

    @Override
    public AuthoritiesDTO updateCodeIfExistId(AuthoritiesDTO authoritiesDTO) throws NotFoundError {
        return mapperServiceHolder
                .toDTO(authoritiesRepository
                        .updateCodeAndCloseValueIfExistId(mapperServiceHolder
                                .toEntity(authoritiesDTO)));
    }


}
