package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.entiry.Authorities;
import org.example.entiry.Owner;
import org.modelmapper.ModelMapper;

import java.util.List;


@Getter
@ToString
@Setter
@NoArgsConstructor
public class AuthoritiesDTO {

    private Long id;

    private String code;

    public static AuthoritiesDTO fromAuthoritiesDTO(Authorities authoritiesPerson) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(authoritiesPerson, AuthoritiesDTO.class);
    }

    public Authorities tAuthoritiesDTO() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Authorities.class);
    }


}