package controller;

import entity.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CartService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class CartController {

    private final CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllOrders(){
        return ResponseEntity.ok(cartService.getAllOrders());
    }

    @PostMapping("/addProducts")
    public ResponseEntity<Cart> createOrder(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.createProduct(cart));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cart>> getOrderById(@PathVariable String id){
        return ResponseEntity.ok(cartService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateOrderStatus(@PathVariable String id, @RequestBody Cart cart){
        return ResponseEntity.ok(cartService.updateOrderStatus(id, cart));
    } 
}


