package pl.pkolkiew.dddhexarch.order.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pkolkiew
 * Created 23.07.2019
 */
@Configuration
class OrderSpringConfiguration {

    @Bean
    OrderFacade orderFacade(OrderRepository orderRepository) {
        OrderCreator orderCreator = new OrderCreator();
        return new OrderFacade(orderRepository, orderCreator);
    }

    @Bean
    OrderRepository orderRepository(){
        return new InMemoryOrderRepository();
    }

}
