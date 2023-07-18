package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "OrderP")
public class OrderP {

    @Id
    @SequenceGenerator(name = "pet_seq",
            sequenceName = "pet_sequence",
            initialValue = 2000, allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private Long id;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "owner_id", nullable = false)
    private UserP user;

    @Column(nullable = false,name = "order_date")
    private LocalDateTime orderDate;

    @Column(nullable = false,name = "total_amount")
    private BigDecimal totalAmount;

    @OrderBy("unitPrice ASC")
    @OneToMany(mappedBy = "orderP")
    List<OrderPItems> orderPItems;

    @OrderBy("isOpen ASC")
    @ManyToMany(mappedBy ="orderPList" )
    private List<Product> products;

}
