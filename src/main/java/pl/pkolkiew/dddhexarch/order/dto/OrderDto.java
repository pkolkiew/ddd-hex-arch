package pl.pkolkiew.dddhexarch.order.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Builder
@Value
@Getter
@EqualsAndHashCode
public class OrderDto {
    private Long orderId;
    private String productName;
    private String userLogin;
}
