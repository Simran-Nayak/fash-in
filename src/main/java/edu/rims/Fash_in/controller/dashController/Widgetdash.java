package edu.rims.Fash_in.controller.dashController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class Widgetdash {
     @GetMapping("/customer/widget")
    String widget() {
        return "customer/widget";
    }
}
@GetMapping ("/widget")
public String getWidgets (Model model){
    model.addAttribute(attributeName:"widgets", widgetRepository.findAll());
    return "customer/widget";
}

