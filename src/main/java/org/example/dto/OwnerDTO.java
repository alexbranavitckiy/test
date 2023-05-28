package org.example.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.Audit.AuditTrailListener;
import org.example.entiry.Authorities;
import org.example.entiry.Owner;
import org.modelmapper.ModelMapper;

import java.util.List;


@Getter
@ToString
@Setter
@NoArgsConstructor
public class OwnerDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private List<AuthoritiesDTO> authorities;

    public static OwnerDTO fromOwnerDTO(Owner authoritiesPerson) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(authoritiesPerson, OwnerDTO.class);
    }

    public Owner toOwner() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Owner.class);
    }


}