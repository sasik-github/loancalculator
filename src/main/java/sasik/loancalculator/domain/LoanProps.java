package sasik.loancalculator.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Component
@ConfigurationProperties(prefix = "loan.props")
@Validated
public class LoanProps
{
    private int maxLoan;
    private int minLoan;

    private int minPeriod;
    private int maxPeriod;

    @DecimalMin(value = "12.9")
    @DecimalMax(value = "23.9")
    private BigDecimal interestPerYear;

    public int getMaxLoan() {
        return maxLoan;
    }

    public void setMaxLoan(int maxLoan) {
        this.maxLoan = maxLoan;
    }

    public int getMinLoan() {
        return minLoan;
    }

    public void setMinLoan(int minLoan) {
        this.minLoan = minLoan;
    }

    public int getMinPeriod() {
        return minPeriod;
    }

    public void setMinPeriod(int minPeriod) {
        this.minPeriod = minPeriod;
    }

    public int getMaxPeriod() {
        return maxPeriod;
    }

    public void setMaxPeriod(int maxPeriod) {
        this.maxPeriod = maxPeriod;
    }

    public BigDecimal getInterestPerYear() {
        return interestPerYear;
    }

    public void setInterestPerYear(BigDecimal interestPerYear) {
        this.interestPerYear = interestPerYear;
    }

    @Override
    public String toString() {
        return "LoanProps{" +
            "maxLoan=" + maxLoan +
            ", minLoan=" + minLoan +
            ", minPeriod=" + minPeriod +
            ", maxPeriod=" + maxPeriod +
            ", interestPerYear=" + interestPerYear +
            '}';
    }
}
