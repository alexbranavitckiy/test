package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@ToString
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String role;

    @ToString.Include
    private List<AuthoritiesDTO> authorities;

}