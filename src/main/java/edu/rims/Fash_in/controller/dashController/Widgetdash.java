package edu.rims.Fash_in.controller.dashController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.rims.Fash_in.constant.WidgetStatus;
import edu.rims.Fash_in.entity.Product;
import edu.rims.Fash_in.entity.Widget;
import edu.rims.Fash_in.repository.*;

import org.springframework.web.multipart.MultipartFile;

@Controller
public class Widgetdash {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WidgetRepository widgetRepository;

    // Create or update a widget
    @PostMapping("/admin/widget/add")
    public String addOrUpdateWidget(
            @RequestParam String widgetName,
            @RequestParam String widgetId,
            @RequestParam int sequence) {
        
        Widget widget = widgetRepository.findById(widgetId).orElse(new Widget());
        widget.setWidgetName(widgetName);
        widget.setSequence(sequence);
        widget.setUpdatedDate(LocalDateTime.now());
        widgetRepository.save(widget);
        return "redirect:/admin/widget";
    }

    // Show form for adding a widget
    @GetMapping("/admin/widget/add")
    public String showAddForm(Model model) {
        model.addAttribute("widget", new Widget());
        return "admin/widget";
    }


    // Remove a widget (mark inactive)
    @GetMapping("/admin/widget/remove")
    public String removeWidget(@RequestParam("id") String widgetId) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();
        widget.setWidgetStatus(WidgetStatus.INACTIVE);
        widgetRepository.save(widget);
        return "redirect:/admin/widget";
    }

    // Edit widget (load data into form)
    @GetMapping("/admin/widget/edit")
    public String editWidget(@RequestParam("id") String widgetId, Model model) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();
        model.addAttribute("widget", widget);
        return "admin/widget";
    }

    // Upload CSV to assign products to widget
    @PostMapping("/admin/widget/product/add")
    public String addProductToWidget(@RequestParam MultipartFile file) {
        if (file.isEmpty()) {
            return "redirect:/admin/widget";
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            bufferedReader.readLine(); // skip header
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                if (split.length >= 2) {
                    processDetails(split[0], split[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return "redirect:/admin/widget";
    }

    // Show widget with products
    @GetMapping("/admin/widget/products")
    public String showWidgetProducts(@RequestParam("id") String widgetId, Model model) {
        model.addAttribute("widget", widgetRepository.findById(widgetId).orElseThrow());
        return "admin/widget-products";
    }

    // Remove a product from a widget
    @GetMapping("/admin/widget/product/remove")
    public String removeProductFromWidget(@RequestParam String widgetId, @RequestParam String productId) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();
        widget.removeProduct(productId);
        widgetRepository.save(widget);
        return "redirect:/admin/widget";
    }

    // Helper method to assign product to widget
    private void processDetails(String widgetId, String productId) {
        Product product = productRepository.findById(productId).orElse(null);
        Widget widget = widgetRepository.findById(widgetId).orElse(null);

        if (product != null && widget != null) {
            if (!widget.getProducts().contains(product)) {
                widget.addProduct(product);
                widgetRepository.save(widget);
            }
        }
    }
}
