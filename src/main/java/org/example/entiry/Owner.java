package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;
import org.example.audit.AuditTrailListener;

import java.util.List;
import java.util.UUID;

@Getter
@ToString
@Setter
@NoArgsConstructor
@Entity(name = "owner")
@Table(name = "owner")
@EntityListeners(AuditTrailListener.class)
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "my_table_generator")
    private UUID id;

    @Column(name = "first_name", length = 200, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 200, nullable = false)
    private String lastName;

    @Column(name = "phone", length = 200, nullable = false)
    private String phone;

    @Column(name = "close", length = 200, nullable = false)
    private boolean close;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<Summer> reporters;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "owners")
    List<Authorities> authorities;

    @OneToMany(mappedBy = "owner")
    List<Message> messages;


}
