package org.progmatic.messenger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class HomeController {

    @RequestMapping(value = "/greet", method = GET)
    public String home(Model model){
        model.addAttribute("message", "hello");
        return "greeting";
    }

    @RequestMapping(value = "/dobokocka", method = GET)
    public String dice(@RequestParam(name = "sides", required = false, defaultValue = "6") int sides, Model model){
        model.addAttribute("roll", (int)(Math.random() * sides) +1);
        return "dice";
    }
}

