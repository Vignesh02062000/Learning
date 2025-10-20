package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Payment {
    @UuidGenerator
    private String paymentId;
    private String CartId;
    private String UserId;
    private String OrderId;
    private Enum PaymentStatus;
    private String PaymentMethod;
    private String PaymentTimestamp;
    private String PaymentMessage;
}
