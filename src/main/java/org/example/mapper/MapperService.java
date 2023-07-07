package org.example.mapper;

public interface MapperService<En,DTO> {

    DTO toDTO(En authorities) ;

     En toEntity(DTO authoritiesDTO) ;

    void updateEntity(DTO authoritiesDTO, En authorities) ;
}
