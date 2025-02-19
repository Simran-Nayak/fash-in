package edu.rims.Fash_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Plp {
    @GetMapping("/customer/plp")
    String plp() {
        return "customer/plp";
    }
}
