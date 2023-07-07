package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@ToString
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Product")
public class Product {

    @Id
    @SequenceGenerator(name = "pet_seq",
            sequenceName = "pet_sequence",
            initialValue = 2000, allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private Long id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "is_open")
    private boolean isOpen;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany
    @JoinColumn(name = "products")
    private List<OrderP> orderPList;

}