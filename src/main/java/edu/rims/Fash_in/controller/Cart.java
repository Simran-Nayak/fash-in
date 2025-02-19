package edu.rims.Fash_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Cart {
    @GetMapping("/customer/cart")
    String cart() {
        return "customer/cart";
    }
}
