package edu.rims.Fash_in.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.Fash_in.entity.Category;

import edu.rims.Fash_in.repository.CategoryRepository;


@Controller
public class PlpController {
    @Autowired
    private CategoryRepository categoryRepository;

    // @GetMapping("/customer/plp") 
    //     String customerPlp(){
    //         return"customer/plp";
    //     } 
    
    @GetMapping("/customer/plp")
    String getProductByCatagoryId(@RequestParam("category") String categoryId,Model model) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        model.addAttribute("category", category);
        // List<Category> categories = categoryRepository.findAll();
        // model.addAttribute("categories", categories);
        return "customer/plp";
    }
}
