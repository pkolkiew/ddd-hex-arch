package pl.pkolkiew.dddhexarch.order.domain;

import pl.pkolkiew.dddhexarch.order.dto.OrderDto;

import static java.util.Objects.requireNonNull;
/**
 * @author pkolkiew
 * Created 23.07.2019
 */
class OrderCreator {

    Order from(OrderDto orderDto){
        requireNonNull(orderDto);
        return Order.builder()
                .orderId(orderDto.getOrderId())
                .productName(orderDto.getProductName())
                .build();
    }
}
