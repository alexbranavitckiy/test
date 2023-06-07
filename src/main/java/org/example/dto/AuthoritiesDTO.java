package org.example.dto;

import lombok.*;

@Getter
@Builder
@ToString
@Setter
@NoArgsConstructor
public class AuthoritiesDTO {

    private Long id;

    private String code;

    private boolean close;




}