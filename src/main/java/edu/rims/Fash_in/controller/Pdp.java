package edu.rims.Fash_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Pdp {
    @GetMapping("/customer/pdp")
    String PageLandingPage() {
        return "customer/pdp";
    }
}
