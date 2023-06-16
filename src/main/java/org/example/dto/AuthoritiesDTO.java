package org.example.dto;

import lombok.*;

@Getter
@Builder
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthoritiesDTO {

    private Long id;

    private String code;

    private boolean close;

}