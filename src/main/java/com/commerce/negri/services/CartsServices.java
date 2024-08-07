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
public class CartsServices {

    @Autowired
    private CartsRepository cartsRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    public Cart addProductToCart(Long clientId, Long productId, Integer amount) {
        Optional<Client> client = clientsRepository.findById(clientId);
        Optional<Product> product = productsRepository.findById(productId);
        if (client.isPresent() & product.isPresent()) {
            Cart cart = new Cart();
            cart.setClient(client.get());
            cart.setProduct(product.get());
            cart.setPrice(product.get().getPrice());
            cart.setDelivered(false);
            return cartsRepository.save(cart);
        } else {
            throw new RuntimeException("Client or Product not found");
        }
    }

    public Cart removeProductFromCart(Long cartId) {
        Optional<Cart> cart = cartsRepository.findById(cartId);

        if (cart.isPresent()) {
            cartsRepository.deleteById(cartId);
            return cart.get();
        }else {
            throw new RuntimeException("Cart not found");
        }

    }

    public List<Cart> findByClientIdAndDelivered(Long clientId) {
        List<Cart> carts = cartsRepository.findByClientIdAndDelivered(clientId, false);
        if (carts.isEmpty()) {
            throw new RuntimeException("Carts not found");
        } else {
            return carts;
        }
    }
}
