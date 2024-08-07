package com.commerce.negri.services;

import com.commerce.negri.entities.Cart;
import com.commerce.negri.entities.Client;
import com.commerce.negri.entities.Product;
import com.commerce.negri.repositories.CartsRepository;
import com.commerce.negri.repositories.ClientsRepository;
import com.commerce.negri.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartsService {

    @Autowired
    private CartsRepository cartRepository;

    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private ClientsRepository clientRepository;

    public Cart addProductToCart(Long clientId, Long productId, Integer amount) {
        Optional<Client> client = clientRepository.findById(clientId);
        Optional<Product> product = productRepository.findById(productId);
        if (client.isPresent() & product.isPresent()) {
            Cart cart = new Cart();
            cart.setClient(client.get());
            cart.setProduct(product.get());
            cart.setPrice(product.get().getPrice());
            cart.setAmount(amount);
            cart.setDelivered(false);
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Client or Product not found");
        }
    }

    public Cart removeProductFromCart(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            cartRepository.deleteById(cartId);
            return cart.get();
        } else {
            throw new RuntimeException("Cart not found");
        }
    }

    public List<Cart> findByClientIdAndDelivered(Long client_id) {
        List<Cart> carts = cartRepository.findByClientIdAndDelivered(client_id, false);
        if (carts.isEmpty()) {
            throw new RuntimeException("Carts not found");
        } else {
            return carts;
        }
    }
}
