package pl.pkolkiew.dddhexarch.order.domain;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author pkolkiew
 * Created 23.07.2019
 */
@Transactional
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final OrderCreator orderCreator;

    public OrderFacade(OrderRepository orderRepository, OrderCreator orderCreator) {
        this.orderRepository = orderRepository;
        this.orderCreator = orderCreator;
    }
}
