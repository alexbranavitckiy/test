package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "OrderPItems")
public class OrderPItems {

    @Id
    @SequenceGenerator(name = "pet_seq",
            sequenceName = "pet_sequence",
            initialValue = 2000, allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private Long id;


    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "orderP_ID")
    private OrderP orderP;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private BigDecimal unitPrice;


}