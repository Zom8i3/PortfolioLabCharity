package pl.coderslab.charity.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

@AllArgsConstructor
@Controller
public class InstitutionController {

    private final InstitutionRepository institutionRepository;

    @GetMapping("/foundation/update/{id}")
    public String getInstitutionInfo(@PathVariable Long id, Model model){
        Institution institution = institutionRepository.getOne(id);
        model.addAttribute("institution",institution);
        return "institutiondetails";
    }

    @PostMapping("/foundation/update/{id}")
    public String postInstitutionInfo(Institution institution){
        institutionRepository.save(institution);
        return "redirect:/admin";
    }

    @GetMapping("/foundation/delete/{id}")
    public String deleteInstitution(@PathVariable Long id){
        institutionRepository.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/foundation/add")
    public String addInstitution(Institution institution){
        System.out.println("HERE: " + institution);
        institutionRepository.save(institution);
        return "redirect:/admin";
    }



}
