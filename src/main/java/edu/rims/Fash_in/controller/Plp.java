package edu.rims.Fash_in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.ProductRepository;


@Controller
public class Plp {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/customer/plp")
    String plp(Model model) {
        List<Product> product =productRepository.findAll();
        model.addAttribute("products", product);
        return "customer/plp";
    }
}
