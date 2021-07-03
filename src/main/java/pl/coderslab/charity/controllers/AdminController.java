package pl.coderslab.charity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@AllArgsConstructor
@Controller
public class AdminController {

    private final InstitutionRepository institutionRepository;

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

    @ModelAttribute("institutions")
    public List<Institution> getInstitutions(){
      return institutionRepository.findAll();
    }

    @GetMapping("admin/foundations")
    public String getFoundation(){
        return "foundations";
    }


}
