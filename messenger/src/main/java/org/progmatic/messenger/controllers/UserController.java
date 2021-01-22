package org.progmatic.messenger.controllers;

//import org.progmatic.messenger.model.User;
import org.progmatic.messenger.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserDetailsService userDetailsService;
  //  private UserService userService;

    @Autowired
    public UserController(UserDetailsService userDetailsService/*, UserService userService*/) {
        this.userDetailsService = userDetailsService;
      //  this.userService = userService;
    }

    @GetMapping(value = "/login")
    public String loginPage(){
        return "loginPage";
    }

    @GetMapping(value = "/register")
    public String registerPage(){
        return "registerPage";
    }

    /*@PostMapping(value = "/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password){
        ((InMemoryUserDetailsManager) userDetailsService).createUser(User.withUsername(username).password(password).roles("USER").build());
        return "redirect:/loginpage";
    }

    /*@PostMapping(value = "/register")
    public String register(@ModelAttribute("newUser") User newUser){
        userService.addNewUser(newUser);
        return "redirect:/loginpage";
    }*/
}
