package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@ToString
@Builder
@Setter
@NoArgsConstructor
@Entity(name = "Owner")
@AllArgsConstructor
@EqualsAndHashCode(of = {"id","reporters","authorities"})
public class Owner  {

    @Id
    @SequenceGenerator(name = "pet_seq",
            sequenceName = "pet_sequence",
            initialValue = 2000, allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private Long id;

    @Column(name = "first_name", length = 200, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 200, nullable = false)
    private String lastName;

    @Column(name = "phone", length = 200, nullable = false)
    private String phone;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "client")
    private List<Summer> reporters;

    @ToString.Exclude
    @ManyToMany(mappedBy = "owners",fetch = FetchType.EAGER)
    List<Authorities> authorities;

}
