package sasik.loancalculator.domain;

import java.math.BigDecimal;

public class Interest
{
    private final double interestPerYear;

    public Interest(LoanProps props) {
        interestPerYear = props.getInterestPerYear().doubleValue();
    }


    private double getRation() {
        return interestPerYear / 100;
    }

    public BigDecimal getMonthRation() {
        return BigDecimal.valueOf(getRation() / 12);
    }
}
