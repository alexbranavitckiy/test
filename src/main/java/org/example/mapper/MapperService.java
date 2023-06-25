package org.example.mapper;

import org.example.dto.AuthoritiesDTO;
import org.example.dto.OwnerDTO;
import org.example.entiry.Authorities;
import org.example.entiry.Owner;
import org.modelmapper.ModelMapper;

public interface MapperService<En,DTO> {

    DTO toDTO(En authorities) ;

     En toEntity(DTO authoritiesDTO) ;

    void updateEntity(DTO authoritiesDTO, En authorities) ;
}
