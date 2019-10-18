package pl.pkolkiew.dddhexarch.order.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

/**
 * @author pkolkiew
 * Created 8/14/2019
 */
class MoneyOrder implements Serializable {

    private final BigDecimal value;
    private final Currency currency;

    public MoneyOrder(String value) {
        this(new BigDecimal(value));
    }

    public MoneyOrder(BigDecimal value) {
        this.value = value;
        currency = Currency.getInstance("PLN");
    }

    public MoneyOrder(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public MoneyOrder(String value, Currency currency) {
        this.value = new BigDecimal(value);
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static MoneyOrder zero() {
        return new MoneyOrder(BigDecimal.ZERO);
    }

    public MoneyOrder add(MoneyOrder money){
        return new MoneyOrder(this.value.add(money.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyOrder money = (MoneyOrder) o;
        return value.compareTo(money.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public boolean lessOrEqualTo(MoneyOrder money) throws Exception {
        if (currency.equals(money.currency))
            return money.value.compareTo(value) <= 0;
        else
            throw new Exception("Currency mismatch, cannot compare values.");
    }

    public MoneyOrder substract(MoneyOrder money) throws Exception {
        if (currency.equals(money.currency))
            return new MoneyOrder(value.subtract(money.value));
        else
            throw new Exception("Currency mismatch, cannot compare values.");
    }

}

