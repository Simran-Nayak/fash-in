package edu.rims.Fash_in.controller.dashController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.rims.Fash_in.constant.WidgetStatus;
import edu.rims.Fash_in.entity.Category;
import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.entity.Widget;
import edu.rims.Fash_in.repository.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class Widgetdash {
       
    private final ProductRepository productRepository;

    private final AdminDash adminDash;

    @Autowired
    private WidgetRepository widgetRepository;

    Widgetdash(AdminDash adminDash, ProductRepository productRepository) {
        this.adminDash = adminDash;
        this.productRepository = productRepository;
    }

    @GetMapping ("/admin/widget")
    public String getWidgets (Model model){
        model.addAttribute("widgets", widgetRepository.findAll());
        return "admin/widget";
    }
    @PostMapping("/admin/widget/add")
    public String postMethodName(@RequestParam String widgetName, @RequestParam String widgetId, @RequestParam int sequence) {
        Widget widget = widgetRepository.findById(widgetId).orElse(new Widget());    
        widget.setWidgetName(widgetName);
        widget.setSequence(sequence);
        widget.setUpdatedDate(LocalDateTime.now());
        widgetRepository.save(widget);
        return "redirect:/admin/widget";
    }
    @GetMapping("/widget/remove")
    public String removeWidget(@RequestParam("id")String widgetId) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();
        widget.setWidgetStatus(WidgetStatus.INACTIVE);
        widgetRepository.save(widget);
        return "redirect:/admin/widget";
    }
    @GetMapping("/widget/edit")
    public String editWidget(@RequestParam("id")String widgetId,Model model) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();
        widget.setWidgetStatus(WidgetStatus.INACTIVE);
        return "redirect:/admin/widget";
    }
    @PostMapping("/widget/product/add")
    public String addProductToWidget(@RequestParam MultipartFile file) {
        if(file.isEmpty())
        return "redirect:/admin/widget" ;
        try{
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(file.getInputStream()));
            Map<String, String> details=new HashMap<>();

            bufferedReader.readLine();
            String line;
            while((line=bufferedReader.readLine())!=null) {
                String[]split=line.split(",");
                processDetails(split[0], split[1]);
            }
            // throw new Exception(e);
        }catch(Exception e){
        }
            return "redirect:/admin/widget";
    }
    @GetMapping("/admin/widget/products")
    public String getMethodName(@RequestParam("id")String widgetId, Model model){
        
        model.addAttribute("widget", widgetRepository.findById(widgetId).orElseThrow());
        return "admin/widget-products";
    }
    private void processDetails(String widgetId,String productId){
        Product product = productRepository.findById(productId).orElse(null);
        Widget widget = widgetRepository.findById(widgetId).orElse(null);
        if(product!=null && widget!=null){
            if(!widget.getProducts().contains(product)){
                widget.addProduct(product);
                widgetRepository.save(widget);
            }
        }
    }
    @GetMapping("/widget/product/remove")
    public String getMethodName(@RequestParam String widgetId, @RequestParam String productId) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();

        widget.removeProduct(productId);

        widgetRepository.save(widget);
        return "redirect:/admin/widget";
    }
}



