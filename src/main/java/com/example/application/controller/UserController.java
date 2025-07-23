package com.example.application.controller;

import com.example.application.entity.User;
import com.example.application.service.UserService;
import com.example.application.service.OrderService;
import com.example.application.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/profile/{userId}")
    public String userProfile(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId).orElse(null);
        List<Order> orders = orderService.getAllOrders().stream()
            .filter(order -> order.getUser() != null && order.getUser().getId().equals(userId))
            .toList();
        model.addAttribute("user", user);
        model.addAttribute("orders", orders);
        return "profile";
    }
} 