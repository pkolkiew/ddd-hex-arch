package pl.pkolkiew.dddhexarch.order.domain;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author pkolkiew
 * Created 23.07.2019
 */
class InMemoryOrderRepository implements OrderRepository {

    private final ConcurrentHashMap<Long, Order> map = new ConcurrentHashMap<>();

    public InMemoryOrderRepository() {
    }

}
