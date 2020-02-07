package sasik.loancalculator.domain;

public class LoanAmount
{
    private final Money amount;

    public LoanAmount(int amount, LoanProps props) {
        if (amount < props.getMinLoan() || amount > props.getMaxLoan()) {
            throw new IllegalArgumentException("Invalid loan amount " + amount);
        }
        this.amount = new Money(amount);
    }

    public Money getAmount() {
        return amount;
    }

}
