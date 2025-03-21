package edu.rims.Fash_in.controller.dashController;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.ProductRepository;



@Controller
public class AdminDash {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/admin/admin")
    String cart(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "admin/admin";
    }
}
