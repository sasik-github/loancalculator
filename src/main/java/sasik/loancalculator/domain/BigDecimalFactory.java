package sasik.loancalculator.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalFactory
{
    public static final RoundingMode roundingMode = RoundingMode.HALF_EVEN;

    public static BigDecimal valueOf(BigDecimal value) {
        return value.setScale(2, roundingMode);
    }

}
