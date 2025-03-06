package edu.rims.Fash_in.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
    @GetMapping("/customer/admin")
    String cart() {
        return "customer/admin";
    }
}
