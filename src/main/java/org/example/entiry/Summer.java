package org.example.entiry;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Builder
@Setter
@NoArgsConstructor
@Entity(name = "Summer")
@AllArgsConstructor
@EqualsAndHashCode(of = {"id","client"})
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "graph.Summer.client",
                attributeNodes = @NamedAttributeNode("client")
        ),
        @NamedEntityGraph(
                name = "graph.Summer.client.authorities",
                attributeNodes = {
                        @NamedAttributeNode(value = "client", subgraph = "client.authorities")
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "client.authorities",
                                attributeNodes = @NamedAttributeNode(value = "authorities")
                        )
                }
        )
})
public class Summer  implements GetId{

    @Id
    @SequenceGenerator(name = "pet_seq",
            sequenceName = "pet_sequence",
            initialValue = 2000, allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private Long id;

    @Column(name = "summer")
    private String summer;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "client_id")
    private Owner client;

}
