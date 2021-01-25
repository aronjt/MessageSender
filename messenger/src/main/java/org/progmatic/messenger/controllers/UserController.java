package org.progmatic.messenger.controllers;

import org.progmatic.messenger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UserController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(value = "/login")
    public String loginPage(){
        return "loginPage";
    }

    @GetMapping(value = "/register")
    public String registerPage(@ModelAttribute("newUser") User newUser){
        return "registerPage";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute("newUser") User newUser){
        ((InMemoryUserDetailsManager) userDetailsService).createUser(newUser);
        System.out.println(newUser.getUsername() + newUser.getPassword() + newUser.getUserRole() + newUser.getAuthorities());
        return "redirect:/login";
    }
}
