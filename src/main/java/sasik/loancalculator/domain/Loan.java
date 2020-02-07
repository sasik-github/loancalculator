package sasik.loancalculator.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;

public class Loan implements Iterable<Payment>
{

    private final LoanAmount amount;
    private final LoanTerm term;
    private final Interest interest;
    private final Money monthlyPayment;
    private final Payment[] payments;

    public Loan(LoanAmount amount, LoanTerm term, Interest interest) {

        this.amount = amount;
        this.term = term;
        this.interest = interest;

        this.monthlyPayment = calculateMonthlyPayment(amount, term, interest);
        payments = fillPayments(amount);

    }

    private Payment[] fillPayments(LoanAmount amount) {

        final Payment[] payments = new Payment[term.getMonths()];

        Money remainAmount = amount.getAmount();
        LocalDate paymentDay = LocalDate.now();
        final BigDecimal interestByMonth = this.interest.getMonthRation();
        for (int i = 0; i < term.getMonths(); i++) {
            Money interest = remainAmount.multiply(interestByMonth);
            payments[i] = new Payment(
                i + 1,
                paymentDay.plusMonths(i),
                monthlyPayment,
                interest,
                remainAmount
            );

            remainAmount = payments[i].getBalance();
        }

        return payments;
    }

    /*
    s = 1 000 000
    p = 13 / 100 / 12 = 0.01083333333
    top = 10833.33333

    posPow = 1.2140371779
    pow = 0.823698003412134

    bot = 1 - (1 + p)^-n = 1 - 1.2140371779^-1 = 1 - 0.823698003412134 = 0.176301996587866

    payment = 61447.592991953700276

     */
    private Money calculateMonthlyPayment(LoanAmount loanAmount, LoanTerm loanTerm, Interest interest) {

        final BigDecimal one = BigDecimal.valueOf(1).setScale(10, RoundingMode.HALF_EVEN);

        BigDecimal top = loanAmount.getAmount().getValue().multiply(interest.getMonthRation());

        BigDecimal positivePow = one.add(interest.getMonthRation()).pow(loanTerm.getMonths());
        BigDecimal pow = one.divide(positivePow, BigDecimalFactory.roundingMode);
        BigDecimal bot = one.subtract(pow);
        BigDecimal payment = top.divide(bot, BigDecimalFactory.roundingMode);

        return new Money(payment);
    }

    @Override
    public Iterator<Payment> iterator() {
        return Arrays.asList(payments).iterator();
    }
}
