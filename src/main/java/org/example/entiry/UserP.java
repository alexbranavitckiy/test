package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;
import org.example.entiry.protection.Authorities;

import java.util.List;

@Getter
@ToString
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UserP")
public class UserP {

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

    @OneToMany(mappedBy ="user")
    private List<OrderP> orders;

    @ToString.Exclude
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    List<Authorities> authorities;

}
