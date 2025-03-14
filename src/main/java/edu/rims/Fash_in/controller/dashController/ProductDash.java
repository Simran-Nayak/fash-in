
package edu.rims.Fash_in.controller.dashController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
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

import edu.rims.Fash_in.entity.Category;
import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.CategoryRepository;
import edu.rims.Fash_in.repository.ProductRepository;

@Controller
public class ProductDash {

     @Autowired
    private ProductRepository productRepository;
     @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/customer/product")
    String cart(Model model) {
        List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "customer/product";
    }

     @PostMapping("/customer/product")
    public String ProductAdd(@ModelAttribute Product product,@RequestParam("productImageFile")MultipartFile file, 
    @RequestParam("categoryId") String categoryId
    )
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

        Category category = categoryRepository.findById(categoryId).orElseThrow();
        product.setCategory(category);
        product.setCreatedDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());
        productRepository.save(product);
        return "redirect:/customer/product";
    }

    @GetMapping(value= "/product/image/{productId}", produces = {"image/jpg","image/jpeg","image/png"})
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

       @PostMapping("/product")
        public String signUp(@ModelAttribute Product product) {
        product.setCreatedDate(LocalDateTime.now()); 
        product.setUpdatedDate(LocalDateTime.now());
        product.setCreatedBy("user");  
        product.setUpdatedBy("user"); 
        product.setProductImageUrl("bksjbkbskbkdbksbbs");
        productRepository.save(product);
        return "redirect:/customer/product";   

    }
}

    //    @PostMapping("/product")
    // public String signUp(@ModelAttribute Product product) {
    //     product.setCreatedDate(LocalDateTime.now()); 
    //     product.setUpdatedDate(LocalDateTime.now());
    //     product.setCreatedBy("user");  
    //     product.setUpdatedBy("user"); 
    //     product.setProductImageUrl("");
    //     productRepository.save(product);
    //     return "redirect:/customer/product";   
    // }
