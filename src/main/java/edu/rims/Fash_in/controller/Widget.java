package edu.rims.Fash_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Widget {
     @GetMapping("/customer/widget")
    String widget() {
        return "customer/widget";
    }
}
