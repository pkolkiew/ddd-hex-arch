package pl.pkolkiew.dddhexarch.order.domain;

import lombok.Builder;
import lombok.Data;
import pl.pkolkiew.dddhexarch.order.dto.OrderDto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Builder
@Data
@Entity(name = "ORDER_DDD")
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
