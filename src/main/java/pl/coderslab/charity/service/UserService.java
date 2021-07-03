package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

import java.util.List;

public interface UserService {

    User findByUserName(String username);
    void saveUser(User user);
    List<User> getAdmins();
    void saveAdmin(User user);
    void deleteAdmin(Long id);
    void updateAdmin(User user);


}
