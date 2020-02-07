package sasik.loancalculator.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Payment
{

    /**
     * Номер платежа
     */
    private final int id;

    /**
     * Месяц/Год
     */
    private final LocalDate date;

    /**
     * Общая сумма платежа
     */
    private final Money totalPayment;

    /**
     * Платеж по основному долгу
     */
    private final Money principal;

    /**
     * Платеж по процентам
     */
    private final Money interest;

    /**
     * Остаток основного долга
     */
    private final Money balance;


    public Payment(int id, LocalDate date, Money totalPayment, Money interest, Money remainsBeforeTotal) {
        this.id = id;
        this.date = date;
        this.totalPayment = totalPayment;
        this.interest = interest;
        this.principal = totalPayment.subtract(interest);
        this.balance = remainsBeforeTotal.subtract(this.principal);
    }

}
