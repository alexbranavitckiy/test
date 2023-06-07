package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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


}