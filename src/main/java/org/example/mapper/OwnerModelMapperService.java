package org.example.mapper;


import org.example.dto.OwnerDTO;
import org.example.entiry.Owner;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OwnerModelMapperService {

    private final ModelMapper modelMapper;

    public OwnerModelMapperService() {
        this.modelMapper = new ModelMapper();
    }

    public OwnerDTO convertToDTO(Owner owner) {
        return modelMapper.map(owner, OwnerDTO.class);
    }

    public Owner convertToEntity(OwnerDTO ownerDTO) {
        return modelMapper.map(ownerDTO, Owner.class);
    }

}