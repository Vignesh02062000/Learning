package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Order {
    @UuidGenerator
    private String orderId;
    private String userId;
    private String productId;
    private double orderAmount;
    private String orderDetails;
    private Enum orderStatus;
    private Enum paymentStatus;
}
