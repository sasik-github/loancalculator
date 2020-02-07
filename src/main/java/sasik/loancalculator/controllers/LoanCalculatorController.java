package sasik.loancalculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sasik.loancalculator.domain.LoanProps;
import sasik.loancalculator.requests.LoanRequest;
import sasik.loancalculator.services.LoanService;

@Controller
@RequestMapping("/")
public class LoanCalculatorController
{

    private final LoanProps props;
    private final LoanService loanService;

    public LoanCalculatorController(LoanProps props, LoanService loanService) {
        this.props = props;
        this.loanService = loanService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("props", props);
        model.addAttribute("loanRequest", new LoanRequest());

        return "loanCalculator/index";
    }

    @PostMapping
    public String calculate(Model model, @ModelAttribute LoanRequest request) {
        model.addAttribute("props", props);
        model.addAttribute("loanRequest", request);
        model.addAttribute("loan", loanService.createLoan(request));

        return "loanCalculator/index";
    }

}
