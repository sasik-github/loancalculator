package sasik.loancalculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sasik.loancalculator.domain.LoanProps;

@Controller
@RequestMapping("/")
public class CreditCalculatorContoller
{

    private final LoanProps props;

    public CreditCalculatorContoller(LoanProps props) {
        this.props = props;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("props", props);
        return "creditCalculator/index";
    }

}
