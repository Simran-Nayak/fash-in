package edu.rims.Fash_in.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import edu.rims.Fash_in.constant.ProductStatus;
import edu.rims.Fash_in.dto.ProductResponseDTO;
import edu.rims.Fash_in.dto.ProductResponseDTO.CategoryResponse;
import edu.rims.Fash_in.entity.Category;
import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.repository.CategoryRepository;
import edu.rims.Fash_in.repository.ProductRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @GetMapping({"/dashboard", "/"})
    public String adminHomePage(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "Admin/admin";
    }
    
    @GetMapping("/product")
    public String adminProductPage(Model model) {
         List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "Admin/product";
    }

    @PostMapping("/product")
    public String productAdd(
            @ModelAttribute Product product,
            @RequestParam(value = "productImageFile", required = false) MultipartFile file,
            @RequestParam String categoryId, @RequestParam(required = false) String imageUrl) throws IOException {
        String productId = product.getProductId();
        product.setProductId(productId == null || productId.isEmpty() || productId.equals(",") ? null : productId);
       
        if (imageUrl !=null && !imageUrl.isEmpty()) {
            product.setProductImageUrl(imageUrl);
        }
        
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;
            
            try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
                fileOutputStream.write(file.getBytes());
            }
            
            product.setProductImageUrl(fileName);
        }
        
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        product.setCategory(category);
        product.setCreatedDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());
        
        productRepository.save(product);
        
        return "redirect:/admin/product";
    }

    @GetMapping("/products/{productId}")
    @ResponseBody 
    public ProductResponseDTO getProduct(@PathVariable String productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setProductId(productId);
        dto.setProductTitle(product.getProductTitle());
        dto.setProductDescription(product.getProductDescription());  // Fixed property name
        dto.setProductPrice(product.getProductPrice());
        
        dto.setProductStatus(product.getProductStatus() != null ? product.getProductStatus().toString() : "Unavailable");
    
        dto.setProductStockQuantity(product.getProductStockQuantity());
        dto.setProductImageUrl(product.getProductImageUrl());  // Fixed case issue
    
        ProductResponseDTO.CategoryResponse category = dto.new CategoryResponse();
        category.setCategoryId(product.getCategory().getCategoryId());
        category.setCategoryTitle(product.getCategory().getCategoryTitle());
    
        dto.setCategory(category);
    
        return dto;
    }

    @GetMapping("/category")
    String cart(Model model) {
        List<edu.rims.Fash_in.entity.Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "admin/category";
    }
// @GetMapping("/product/remove")
// public String removeProduct(@RequestParam("id") String productId) {
//     Product product = productRepository.findById(productId).orElseThrow();
//     product.setProductStatus(ProductStatus.INACTIVE.toString());
//     productRepository.save(product);
//     return new String();

@GetMapping("/product/remove")
public ResponseEntity<String> removeProduct(@RequestParam("id") String productId) {
    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

    product.setProductStatus(ProductStatus.INACTIVE); // Assuming ProductStatus is an Enum
    productRepository.save(product);

    return ResponseEntity.ok("Product deactivated successfully");
}
    
    
    @GetMapping("/widget")
    public String adminWidgetPage(Model model) {
        model.addAttribute("title", "Manage Widgets");
        return "Admin/widget";
    }
}
