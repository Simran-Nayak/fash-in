package edu.rims.Fash_in.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.Fash_in.entity.User;
import edu.rims.Fash_in.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/customer")
public class SignUpController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping({"/sign-up", "/"})
    String signUp() {
        return "customer/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute User user) {
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        user.setCreatedDate(LocalDateTime.now()); 
        user.setUpdatedDate(LocalDateTime.now());
        user.setCreatedBy("user");  
        user.setUpdatedBy("user"); 
        userRepository.save(user);
        return "redirect:/customer/sign-in";    
    }
    
}
