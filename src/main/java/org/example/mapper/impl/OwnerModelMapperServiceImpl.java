package org.example.mapper.impl;


import org.example.dto.OwnerDTO;
import org.example.entiry.Owner;
import org.example.mapper.MapperService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OwnerModelMapperServiceImpl implements MapperService<Owner, OwnerDTO> {

    private final ModelMapper modelMapper;

    public OwnerModelMapperServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    public OwnerDTO toDTO(Owner owner) {
        return modelMapper.map(owner, OwnerDTO.class);
    }

    public Owner toEntity(OwnerDTO ownerDTO) {
        return modelMapper.map(ownerDTO, Owner.class);
    }

    @Override
    public void updateEntity(OwnerDTO ownerDTO, Owner owner) {
        modelMapper.map(ownerDTO, owner);
    }
}