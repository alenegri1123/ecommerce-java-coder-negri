package com.commerce.negri.repositories;

import com.commerce.negri.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartsRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByClientIdAndDelivered(Long ClientId, Boolean delivered);
}
