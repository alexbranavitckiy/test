package org.example.entiry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;




@Getter
@ToString
@Setter
@NoArgsConstructor
@Entity(name = "message")
@Table(name = "message")
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "my_table_generator")
    private UUID id;

    @Column(name = "message", length = 200, nullable = false)
    private String message;

    @Column(name = "type", length = 200, nullable = false)
    private String type;

    @Column(name = "flag", length = 200, nullable = false)
    private boolean flag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @JsonIgnore
    private Owner owner;

}
