 package edu.rims.Fash_in.controller;
 import java.io.FileInputStream;
 import java.io.IOException;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.ResponseBody;

 import edu.rims.Fash_in.entity.Product;
 import edu.rims.Fash_in.repository.ProductRepository;

 @Controller
 public class ProductController {
     @Autowired
     private ProductRepository productRepository;

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
 }
