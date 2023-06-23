package org.example.entiry;

import jakarta.persistence.*;
import lombok.*;
import org.example.audit.AuditTrailListener;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "summer")
@EntityListeners(AuditTrailListener.class)
public class Summer  {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "my_table_generator")
    private UUID id;

    @Column(name = "summer")
    private String summer;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @EqualsAndHashCode.Exclude
    private Owner client;

}
