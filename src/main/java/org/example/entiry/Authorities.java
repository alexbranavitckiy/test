package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;
import org.example.audit.AuditTrailListener;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@Entity(name = "authorities")
@Table(name = "authorities")
@AllArgsConstructor
@EntityListeners(AuditTrailListener.class)
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "my_table_generator")
    private UUID id;

    @Column(name = "code")
    private String code;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<Owner> owners;

    public Authorities(UUID id, String code) {
        this.id = id;
        this.code = code;
    }

    public Authorities(String code) {
        this.code = code;
    }

}
