package edu.rims.Fash_in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.Fash_in.constant.WidgetStatus;
import edu.rims.Fash_in.entity.Category;
import edu.rims.Fash_in.entity.Widget;
import edu.rims.Fash_in.repository.CategoryRepository;
import edu.rims.Fash_in.repository.WidgetRepository;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CategoryRepository categoryRepository;

@Autowired
private WidgetRepository widgetRepository;

@GetMapping({"/home","/"})
String home(Model model){
    List<Category> categories = categoryRepository.findAll();

    model.addAttribute("categories",categories);
    // model.addAttribute("widgets",widgetRepository.findByWidgetStatus(WidgetStatus.ACTIVE, Sort.by("sequence")));
    return "user/home";
}
}

