package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.User;

import java.util.HashSet;
import java.util.Set;

public class SpringDataUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService){
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println("Username: " + username);
        User user = userService.findByUserName(username);  //gets user from db based on username
        if(user == null) {  //if doesn't exist in DB, throws exception
            System.out.println("NOT FOUND!!");
            throw new UsernameNotFoundException(username);
        }
        System.out.println("SUCCESS!");
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(r ->
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));

        return new CurrentUser(user.getUsername(),user.getPassword(),grantedAuthorities,user);
    }
}
