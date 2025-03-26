package edu.rims.Fash_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderHistory {
    @GetMapping("/customer/orderhistory")
    String cart() {
        return "customer/orderhistory";
    }
}