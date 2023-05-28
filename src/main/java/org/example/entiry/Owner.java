package org.example.entiry;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.checkerframework.checker.units.qual.A;
import org.example.Audit.AuditTrailListener;

import java.util.List;

@Getter
@ToString
@Setter
@NoArgsConstructor
@Entity(name = "Owner")
@EntityListeners(AuditTrailListener.class)
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 200, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 200, nullable = false)
    private String lastName;

    @Column(name = "phone", length = 200, nullable = false)
    private String phone;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "client",cascade = CascadeType.ALL)
    private List<Summer> reporters;

    @ToString.Exclude
    @ManyToMany(mappedBy = "owners",cascade = CascadeType.ALL)
    List<Authorities> authorities;

}
