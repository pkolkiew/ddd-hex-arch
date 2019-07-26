package pl.pkolkiew.dddhexarch.order.domain;

/**
 * @author pkolkiew
 * Created 23.07.2019
 */
class OrderConfiguration {

    OrderFacade orderFacade() {
        return orderFacade(new InMemoryOrderRepository());
    }

    private OrderFacade orderFacade(OrderRepository orderRepository) {
        OrderCreator orderCreator = new OrderCreator();
        return new OrderFacade(orderRepository, orderCreator);
    }

}
