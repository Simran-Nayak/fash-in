package edu.rims.Fash_in.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.Fash_in.constant.ProductStatus;
import edu.rims.Fash_in.entity.Category;
import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.CategoryRepository;
import edu.rims.Fash_in.repository.ProductRepository;


@Controller
public class PlpController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // @GetMapping("/customer/plp") 
    //     String customerPlp(){
    //         return"customer/plp";
    //     } 
    
    @GetMapping("/customer/plp")
    String getProductByCatagoryId(@RequestParam("category") String categoryId,Model model) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        model.addAttribute("category", category);
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "customer/plp";
    }
    // @GetMapping("/customer/search")
    // String getProductByCatagorySearch(@RequestParam("search") String search,Model model) {
    //     List<Product> products = productRepository.findByProductTitleContainingIgnoreCaseAndProductStatus(search, ProductStatus.ACTIVE);
    //     model.addAttribute("products", products);
    //     List<Category> categories = categoryRepository.findAll();
    //     model.addAttribute("categories", categories);
    //     System.out.println(products.size());
    //     return "customer/plp";
    // }

    @GetMapping("/customer/search")
    String searchProduct(@RequestParam String search, Model model){
        List<Product> products = productRepository
            .findByProductTitleContainingIgnoreCaseAndProductStatus(search, ProductStatus.ACTIVE);
        model.addAttribute("products", products);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        
        return "customer/plp";
    }

    @GetMapping ("/product/search")
    String searchProduct(){
        return "customer/plp";
    }
}
    
