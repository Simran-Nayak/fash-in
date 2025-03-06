package edu.rims.Fash_in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.ProductRepository;

@Controller
public class PdpController {
     @Autowired
    private ProductRepository productRepository;
    // @GetMapping("/customer/pdp") 
    //     String customerPdp(){
    //         return"customer/pdp";
    //     } 
    
        @GetMapping("/customer/product/pdp")
    String getProductByProductId(@RequestParam("product") String productId,Model model) {
        Product product = productRepository.findById(productId).orElseThrow();
        model.addAttribute("product", product);
        // List<Product> products = productRepository.findAll();
        // model.addAttribute("products", products);
        return "customer/pdp";
    }
}
