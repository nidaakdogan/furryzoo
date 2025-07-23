package com.example.application.controller;

import com.example.application.entity.Order;
import com.example.application.service.OrderService;
import com.example.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/user/{userId}")
    public String listUserOrders(@PathVariable Long userId, Model model) {
        List<Order> orders = orderService.getAllOrders().stream()
            .filter(order -> order.getUser() != null && order.getUser().getId().equals(userId))
            .toList();
        model.addAttribute("orders", orders);
        return "orders";
    }
} 