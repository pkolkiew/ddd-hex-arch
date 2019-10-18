package pl.pkolkiew.dddhexarch.order.dto;

/**
 * @author pkolkiew
 * Created 8/14/2019
 */
public class PaymentResponseDto {
    private final String paymentId;

    public PaymentResponseDto(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentId() {
        return paymentId;
    }
}
