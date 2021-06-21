package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
public class HomeController {


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", InstitutionRepository.findAll);

        return "index";
    }
}
