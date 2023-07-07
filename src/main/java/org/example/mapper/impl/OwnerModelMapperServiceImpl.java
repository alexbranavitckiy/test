package org.example.mapper.impl;


import org.example.dto.UserDTO;
import org.example.entiry.UserP;
import org.example.mapper.MapperService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OwnerModelMapperServiceImpl implements MapperService<UserP, UserDTO> {

    private final ModelMapper modelMapper;

    public OwnerModelMapperServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    public UserDTO toDTO(UserP owner) {
        return modelMapper.map(owner, UserDTO.class);
    }

    public UserP toEntity(UserDTO ownerDTO) {
        return modelMapper.map(ownerDTO, UserP.class);
    }

    @Override
    public void updateEntity(UserDTO ownerDTO, UserP owner) {
        modelMapper.map(ownerDTO, owner);
    }
}