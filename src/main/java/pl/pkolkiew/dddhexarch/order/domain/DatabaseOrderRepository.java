package pl.pkolkiew.dddhexarch.order.domain;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
class DatabaseOrderRepository implements OrderRepository {

    private OrderJpaRepository orderJpaRepository;

    public DatabaseOrderRepository(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

}
