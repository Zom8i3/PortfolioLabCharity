package pl.coderslab.charity.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

@Controller
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/form")
    public String showDonationForm(Model model) {
        model.addAttribute("donation",new Donation());  //for binding
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("institutions",institutionRepository.findAll());
        return "form";
    }

    @PostMapping("/form")
    public String submitDonationForm(Donation donation){
        System.out.println("DONATION :" + donation.toString());
        donationRepository.save(donation);
        return "form_confirm";
    }

}
