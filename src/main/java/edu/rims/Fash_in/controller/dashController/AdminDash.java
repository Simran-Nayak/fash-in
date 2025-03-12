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

import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


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
    @PostMapping("/Customer/product")
    public String ProductAdd(@ModelAttribute Product product,@RequestParam("productImageFile")MultipartFile file)
    throws IOException{
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName ="upload_images/" + UUID.randomUUID().toString()+extName;
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
            product.setProductImageUrl(fileName);  
        }
        productRepository.save(product);
        return "redirect:/customer/product";
    }

    @GetMapping(value= "/Product/image/{productId}", produces = {"image/jpg","image/jpeg","image/png"})
    @ResponseBody
    public byte[] getImage (@PathVariable String productId) throws IOException{
        Product product = productRepository.findById(productId).orElseThrow();
        String productImageUrl = product.getProductImageUrl();
        if (productImageUrl==null|| productImageUrl.startsWith("http")) {
            return null;
            
        }
        FileInputStream fis = new FileInputStream(productImageUrl);
        byte[] image=fis.readAllBytes();
        fis.close();
        return image;
    }
    
}
