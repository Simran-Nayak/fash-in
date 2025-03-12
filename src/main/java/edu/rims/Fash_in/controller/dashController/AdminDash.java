package edu.rims.Fash_in.controller.dashController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.ProductRepository;

@Controller
public class AdminDash {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/customer/admin")
    String cart(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "customer/admin";
    }
}
