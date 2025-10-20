package service;

import entity.Cart;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private static final Logger log = LoggerFactory.getLogger(CartService.class);

    public List<Cart> getAllOrders(){
        return cartRepository.findAll();
    }

    public Cart createProduct(Cart cart){
        return cartRepository.save(cart);
    }

    public Optional<Cart> getOrderById (String id){
        return cartRepository.findById(id);

                }
}
