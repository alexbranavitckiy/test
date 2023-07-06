package org.example.entiry.protection;


import jakarta.persistence.*;
import lombok.*;
import org.example.entiry.UserP;

import java.util.List;

@Getter
@Builder
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "Authorities")
@AllArgsConstructor
@EqualsAndHashCode(of = {"author", "id",})
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "graph.Authorities.users",
                attributeNodes = @NamedAttributeNode("users")
        )
})
public class Authorities {

    @Id
    @SequenceGenerator(name = "pet_seq",
            sequenceName = "pet_sequence",
            initialValue = 2000, allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private Long id;

    @Column(name = "close", columnDefinition = "boolean default false")
    private boolean close;

    @Column(name = "code")
    private String code;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn
    @ToString.Exclude
    List<UserP> users;

    @Column(name = "role")
    private Role role;
}
