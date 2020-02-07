package sasik.loancalculator.services;

import org.springframework.stereotype.Service;
import sasik.loancalculator.domain.*;
import sasik.loancalculator.requests.LoanRequest;

@Service
public class LoanService
{

    private final LoanProps props;

    public LoanService(LoanProps props) {
        this.props = props;
    }

    public Loan createLoan(LoanRequest loanRequest) {

        LoanAmount loanAmount = new LoanAmount(loanRequest.getAmount(), props);
        LoanTerm loanTerm = new LoanTerm(loanRequest.getTerm(), props);
        Interest interest = new Interest(props);

        return new Loan(loanAmount, loanTerm, interest);
    }
}
