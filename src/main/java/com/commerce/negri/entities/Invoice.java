package com.commerce.negri.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor @ToString @EqualsAndHashCode
public class Invoice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    @Getter @Setter private List<Cart> carts;
    @Getter @Setter double total;
    @Getter @Setter LocalDateTime created_at;

    @ManyToOne @JoinColumn(name = "client_id")
    private Client client;

}
