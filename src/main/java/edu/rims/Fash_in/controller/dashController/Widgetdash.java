package edu.rims.Fash_in.controller.dashController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Widgetdash {
     @GetMapping("/customer/widget")
    String widget() {
        return "customer/widget";
    }
}
