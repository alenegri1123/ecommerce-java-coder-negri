package com.commerce.negri.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @ToString @EqualsAndHashCode
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    @Getter @Setter private Integer amount;
    @Getter @Setter private double price;
    @Getter @Setter private Boolean delivered;

    @ManyToOne @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne @JoinColumn(name = "client_id")
    private Client client;


}
