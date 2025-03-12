package edu.rims.Fash_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @GetMapping("/customer/dashController/cart")
    String cart() {
        return "customer/dashController/cart";
    }
}
