package service;

import entity.Order;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order createProduct(Order order){
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById (String id){
        return orderRepository.findById(id);
    }

    public Order updateOrderStatus (String id, Order order) {
        return orderRepository.findById(id).map(existingOrder -> {
                    existingOrder.setOrderAmount(order.getOrderAmount());
                    existingOrder.setOrderDetails(order.getOrderDetails());
                    existingOrder.setOrderStatus(order.getOrderStatus());
                    return orderRepository.save(existingOrder);
                })
                .orElseThrow(() -> {
                    log.error("Product not found with id: " + id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id);
                });
                }
}
