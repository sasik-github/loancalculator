package sasik.loancalculator.domain;

public class LoanTerm
{

    private final int months;

    public LoanTerm(int months, LoanProps props) {
        if (months < props.getMinTerm() || months > props.getMaxTerm()) {
            throw new IllegalArgumentException("Invalid loan period " + months);
        }
        this.months = months;

    }

    public int getMonths() {
        return months;
    }
}
