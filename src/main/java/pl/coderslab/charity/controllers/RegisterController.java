package pl.coderslab.charity.controllers;

import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.UserServiceImp;

@Controller
public class RegisterController {

    private final UserRepository userRepository;
    private final UserServiceImp userServiceImp;

    public RegisterController(UserRepository userRepository, UserServiceImp userServiceImp) {
        this.userRepository = userRepository;
        this.userServiceImp = userServiceImp;
    }


    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String postForm(User user){
        System.out.println("HERE" + user.toString());
        if(!user.getPassword().equals(user.getPassword2())){
            System.out.println("Passwords dont match!");
            return "register";
        }else{
            System.out.println("SUCCESS");
            userServiceImp.saveUser(user);
            return "index";
        }
    }


}
