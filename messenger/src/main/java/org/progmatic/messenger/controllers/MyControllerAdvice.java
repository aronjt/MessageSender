package org.progmatic.messenger.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String handleErrors(Exception ex, Model model) {
        model.addAttribute("message", ex);
        return "NewError";
    }
}
