package sasik.loancalculator.domain;

import java.math.BigDecimal;

public class Money
{
    private final BigDecimal value;

    public Money(BigDecimal value) {
        this.value = BigDecimalFactory.valueOf(value);
    }

    public Money(int amount) {
        this(BigDecimal.valueOf(amount));
    }

    public Money multiply(BigDecimal b) {
        return new Money(value.multiply(b));
    }

    public Money subtract(Money b) {
        return new Money(value.subtract(b.value));
    }


    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
