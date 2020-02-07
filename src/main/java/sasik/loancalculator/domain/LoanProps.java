package sasik.loancalculator.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Component
@ConfigurationProperties(prefix = "loan.props")
@Validated
@Data
public class LoanProps
{
    private int maxLoan;
    private int minLoan;

    private int minTerm;
    private int maxTerm;

    @DecimalMin(value = "12.9")
    @DecimalMax(value = "23.9")
    private BigDecimal interestPerYear;

}
