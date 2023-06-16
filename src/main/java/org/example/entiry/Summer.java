package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Builder
@Setter
@NoArgsConstructor
@Entity(name = "Summer")
@AllArgsConstructor
public class Summer  implements GetId{

    @Id
    @SequenceGenerator(name = "pet_seq",
            sequenceName = "pet_sequence",
            initialValue = 2000, allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private Long id;

    @Column(name = "summer")
    private String summer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Owner client;

}
