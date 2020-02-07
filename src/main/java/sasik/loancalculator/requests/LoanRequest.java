package sasik.loancalculator.requests;

import lombok.Data;

@Data
public class LoanRequest
{
    private int amount = 1_000_000;

    private int term = 18;
}
