package edu.rims.Fash_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import edu.rims.Fash_in.entity.Category;
import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.ProductRepository;
import edu.rims.Fash_in.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.Collections;

@Controller
public class CartController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/customer/cart")
    public String showCart(@RequestParam(value = "product", required = false) String productId, Model model) {

        List<Product> products;
        
        if (productId != null) {
            Optional<Product> product = productRepository.findById(productId);
            products = product.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            products = productRepository.findAll(); // Fetch all products if no specific product is requested
        }

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);

        return "customer/cart";
    }
}
