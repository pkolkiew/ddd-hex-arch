package pl.pkolkiew.dddhexarch.order.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author pkolkiew
 * Created 8/14/2019
 */
@Builder
@Data
@Entity(name = "PAYMENT_ORDER")
class PaymentOrder {

    private UUID paymentId;
    private MoneyOrder money;
    private LocalDateTime paymentDateTime;
    private String paymentStatus;
    private UUID payerId;
    private UUID receiverId;

    public PaymentOrder() {
    }

    public PaymentOrder(UUID paymentId, MoneyOrder money, LocalDateTime paymentDateTime, UUID payerId, UUID receiverId) {
        this.paymentId = paymentId;
        this.money = money;
        this.paymentDateTime = paymentDateTime;
        this.payerId = payerId;
        this.receiverId = receiverId;
    }

    public PaymentOrder(UUID paymentId, MoneyOrder money, LocalDateTime paymentDateTime, String paymentStatus, UUID payerId, UUID receiverId) {
        this.paymentId = paymentId;
        this.money = money;
        this.paymentDateTime = paymentDateTime;
        this.paymentStatus = paymentStatus;
        this.payerId = payerId;
        this.receiverId = receiverId;
    }

    public PaymentOrder changeStatus(String newStatus) {
        this.setPaymentStatus(newStatus);
        return this;
    }
}
