package edu.rims.Fash_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignIn {

    @GetMapping("/customer/sign-in")
    String home() {
        return "customer/sign-in";
    }
}
