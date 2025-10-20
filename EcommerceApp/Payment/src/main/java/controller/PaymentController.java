package controller;

import entity.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PaymentService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class PaymentController {

    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllOrders(){
        return ResponseEntity.ok(paymentService.getAllOrders());
    }

    @PostMapping("/addProducts")
    public ResponseEntity<Payment> createOrder(@RequestBody Payment payment){
        return ResponseEntity.ok(paymentService.createProduct(payment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Payment>> getOrderById(@PathVariable String id){
        return ResponseEntity.ok(paymentService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updateOrderStatus(@PathVariable String id, @RequestBody Payment payment){
        return ResponseEntity.ok(paymentService.updateOrderStatus(id, payment));
    } 
}


