package controller;

import entity.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.OrderService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping("/addProducts")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.createProduct(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable String id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable String id, @RequestBody Order order){
        return ResponseEntity.ok(orderService.updateOrderStatus(id, order));
    } 
}


