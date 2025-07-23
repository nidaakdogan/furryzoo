package com.example.application.controller;

import com.example.application.entity.Product;
import com.example.application.entity.User;
import com.example.application.repository.ProductRepository;
import com.example.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @PostMapping("/add-product")
    public String addProduct(@RequestParam String name, @RequestParam double price, @RequestParam String description) {
        productRepository.save(new Product(name, price, description));
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (userRepository.findByEmail(username) != null) {
            model.addAttribute("error", "Kullanıcı adı zaten alınmış.");
            return "register";
        }
        userRepository.save(new User(username, passwordEncoder.encode(password)));
        return "redirect:/login";
    }

    @GetMapping("/hakkinda")
    public String hakkinda() {
        return "hakkinda";
    }
} 