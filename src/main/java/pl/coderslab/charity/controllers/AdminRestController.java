package pl.coderslab.charity.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.UserServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
public class AdminRestController {

    private final UserRepository userRepository;
    private final UserServiceImp userServiceImp;

    @GetMapping("/restapi/show")
    public List<User> addAdmin(){
        return userServiceImp.getAdmins();
    }


    @PostMapping("/restapi/add")
    public void addAdmin(@RequestBody User user){
        userServiceImp.saveAdmin(user);
    }

    @PutMapping("/restapi/update/{id}")
    public void updateAdmin(@RequestBody User user, @PathVariable Long id){
        User updateUser = userRepository.getOne(id);
        updateUser.setName(user.getName());
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        userServiceImp.updateAdmin(updateUser);
    }

    @DeleteMapping("/restapi/delete/{id}")
    public void deleteAdmin(@PathVariable Long id){
        userServiceImp.deleteAdmin(id);

    }



}
