package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;
import org.example.audit.AuditTrailListener;

import java.util.List;

@Getter
@Builder
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "Authorities")
@AllArgsConstructor
@EntityListeners(AuditTrailListener.class)
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

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    @ToString.Exclude
    List<Owner> owners;


}
