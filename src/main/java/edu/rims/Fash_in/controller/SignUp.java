package edu.rims.Fash_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUp {
    @GetMapping("/customer/sign-up")
    String cart() {
        return "customer/sign-up";
    }
}
