package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity(name = "Authorities")
@AllArgsConstructor
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn
    @ToString.Exclude
    List<Owner> owners;

    public Authorities(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public Authorities(String code) {
        this.code = code;
    }
}
