package org.example.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.entiry.Owner;
import org.example.entiry.Summer;
import org.modelmapper.ModelMapper;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class SummerDTO {

    private Long id;

    private String summer;

}
