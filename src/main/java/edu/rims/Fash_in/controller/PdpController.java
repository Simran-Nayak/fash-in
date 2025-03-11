package edu.rims.Fash_in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.Fash_in.entity.Category;
import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.ProductRepository;
import edu.rims.Fash_in.repository.CategoryRepository;

@Controller
public class PdpController {
     @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    // @GetMapping("/customer/pdp") 
    //     String customerPdp(){
    //         return"customer/pdp";
    //     } 
    
        @GetMapping("/customer/product/pdp")
    String getProductByProductId(@RequestParam("product") String productId,Model model) {
        Product product = productRepository.findById(productId).orElseThrow();
        model.addAttribute("product", product);
        List<Category> categories =categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "customer/pdp";
    }
}
