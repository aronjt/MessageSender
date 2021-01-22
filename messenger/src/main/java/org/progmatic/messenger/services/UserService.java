package org.progmatic.messenger.services;

import org.progmatic.messenger.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("user", "password", "user@gmail.com", "1996-10-14"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(s)) {
                return user;
            }
        }
        return null;
    }

    public void addNewUser(User newUser) {
        users.add(newUser);
    }
}
