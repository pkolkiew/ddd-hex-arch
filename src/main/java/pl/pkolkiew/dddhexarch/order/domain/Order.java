package pl.pkolkiew.dddhexarch.order.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import pl.pkolkiew.dddhexarch.order.dto.OrderDto;

import javax.persistence.Entity;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Entity
@Builder
@EqualsAndHashCode
class Order {

    @Id
    private Long orderId;
    private String productName;
    private String userLogin;

    OrderDto dto() {
        return OrderDto.builder()
                .orderId(orderId)
                .productName(productName)
                .userLogin(userLogin)
                .build();
    }
}
