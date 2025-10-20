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
public class User {
    @UuidGenerator
    private String userId;
    private String userName;
    private String userAddress;
    private String userPassword;
    private String userEmailId;
    private String userPhoneNumber;
    private String paymentId;
    private String orderId;
}
