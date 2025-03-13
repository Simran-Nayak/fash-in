package edu.rims.Fash_in.controller.dashController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import edu.rims.Fash_in.repository.CategoryRepository;


@Controller
public class CategoryDash {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/customer/category")
    String cart(Model model) {
        List<edu.rims.Fash_in.entity.Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "customer/category";
    }
}
