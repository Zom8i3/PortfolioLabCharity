package pl.coderslab.charity.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        if(userRepository.findByUsername(user.getUsername()) == null){  //does User already exist?
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setEnabled(1);
            Role userRole = roleRepository.findByName("ROLE_USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            userRepository.save(user);
        }
        System.out.println("User Email Exists!");


    }

    @Override
    public List<User> getAdmins() {
        Role admin = roleRepository.findByName("ROLE_ADMIN");
        return userRepository.findUsersByRoles(admin);
    }

    @Override
    public void saveAdmin(User user) {
        if(userRepository.findByUsername(user.getUsername()) == null){  //does User already exist?
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setEnabled(1);
            Role userRole = roleRepository.findByName("ROLE_ADMIN");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            userRepository.save(user);
        }
        System.out.println("User Email Exists!");

    }

    @Override
    public void updateAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteAdmin(Long id) {
        User user = userRepository.getOne(id);
        user.setRoles(null);
        userRepository.save(user);
        userRepository.deleteById(id);
    }


}
