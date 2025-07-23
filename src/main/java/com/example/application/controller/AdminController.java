package com.example.application.controller;

import com.example.application.service.ProductService;
import com.example.application.service.CategoryService;
import com.example.application.service.UserService;
import com.example.application.service.OrderService;
import com.example.application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("productCount", productService.getAllProducts().size());
        model.addAttribute("categoryCount", categoryService.getAllCategories().size());
        model.addAttribute("userCount", userService.getAllUsers().size());
        model.addAttribute("orderCount", orderService.getAllOrders().size());
        return "admin-dashboard";
    }
} 