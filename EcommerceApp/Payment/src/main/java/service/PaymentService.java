package service;

import entity.Payment;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    public List<Payment> getAllOrders(){
        return paymentRepository.findAll();
    }

    public Payment createProduct(Payment payment){
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getOrderById (String id){
        return paymentRepository.findById(id);

                }
}
