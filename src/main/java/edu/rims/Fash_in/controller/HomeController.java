package edu.rims.Fash_in.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.Fash_in.entity.Category;
import edu.rims.Fash_in.repository.CategoryRepository;

@Controller
// @RequestMapping("/customer")
public class HomeController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/customer/home")
    String home(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "customer/home";
    }
}


