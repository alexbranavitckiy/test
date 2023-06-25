package org.example.mapper.impl;


import org.example.dto.AuthoritiesDTO;
import org.example.entiry.Authorities;
import org.example.mapper.MapperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesMapperServiceImpl implements MapperService<Authorities, AuthoritiesDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public AuthoritiesMapperServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public AuthoritiesDTO toDTO(Authorities authorities) {
        return modelMapper.map(authorities, AuthoritiesDTO.class);
    }

    @Override
    public Authorities toEntity(AuthoritiesDTO authoritiesDTO) {
        return modelMapper.map(authoritiesDTO, Authorities.class);
    }

    @Override
    public void updateEntity(AuthoritiesDTO authoritiesDTO, Authorities authorities) {
        modelMapper.map(authoritiesDTO, authorities);
    }

}




