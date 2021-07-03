package pl.coderslab.charity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;

@Controller
@AllArgsConstructor

public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/admin/users")
    public String showUsers(){
        return "users";
    }

    @GetMapping("/admin/users/update/{id}")
    public String updateUser(@PathVariable Long id, Model model){
        User user = userRepository.getOne(id);
        model.addAttribute("user",user);
        return "userdetails";
    }

    @PostMapping("/admin/users/update/{id}")
    public String postUpdate(@PathVariable Long id, User user){
        User updateUser = userRepository.getOne(id);
        updateUser.setUsername(user.getUsername());
        updateUser.setName(user.getName());
        userRepository.save(updateUser);
        return "users";
    }

    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
//        return "users"; //why do I need to redirect below, shouldn't @ModelAttribute send the updated list automatically?
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/disable/{id}")
    public String disableUser(@PathVariable Long id){
        User user = userRepository.getOne(id);
        if(user.getEnabled() == 1){
            user.setEnabled(0);
        }else{
            user.setEnabled(1);
        }
        userRepository.save(user);
        return "users";
    }

    @ModelAttribute("users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }



}
