package edu.rims.Fash_in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.Fash_in.entity.Category;
import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.CategoryRepository;
import edu.rims.Fash_in.repository.ProductRepository;


@Controller
public class Plp {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/customer/plp")
    String plp(@RequestParam("category") String categoryId,Model model) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        model.addAttribute("category", category);
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "customer/plp";
    }
}
