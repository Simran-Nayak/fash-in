package edu.rims.Fash_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.rims.Fash_in.entity.User;

@Controller
public class SignInController {
    @GetMapping("/customer/sign-in")
    String signIn() {
        return "customer/sign-in";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute User user){
        return "redirect:/customer/login";
    }
}
