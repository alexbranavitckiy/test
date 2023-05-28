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

    public static SummerDTO fromSummerDTO( Summer authoritiesPerson) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(authoritiesPerson, SummerDTO.class);
    }

    public Summer toSummerDTO() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this,  Summer.class);
    }

}
