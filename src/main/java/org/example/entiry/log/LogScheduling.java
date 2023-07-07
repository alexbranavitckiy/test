package org.example.entiry.log;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Objects;
import java.util.UUID;

@Entity(name = "log_scheduling")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@Table(name = "log_scheduling")
@AllArgsConstructor
public class LogScheduling {

    @Id
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private UUID id;


    @Column(name = "message")
    private String message;


}
