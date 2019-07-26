package pl.pkolkiew.dddhexarch.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pkolkiew
 * Created 23.07.2019
 */
interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
