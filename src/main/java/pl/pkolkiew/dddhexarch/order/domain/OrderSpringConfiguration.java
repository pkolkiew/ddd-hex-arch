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
    OrderFacade orderFacade() {
        return new OrderFacade(orderRepository(), new OrderCreator());
    }

    @Bean
    OrderRepository orderRepository() {
        return new InMemoryOrderRepository();
    }

}
