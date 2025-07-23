package com.example.application.controller;

import com.example.application.entity.Cart;
import com.example.application.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public String getCart(Model model) {
        Long userId = 1L; // Giriş sistemi yoksa sabit
        Cart cart = cartService.getCartByUserId(userId).orElse(null);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/{userId}")
    public String getCart(@PathVariable Long userId, Model model) {
        Cart cart = cartService.getCartByUserId(userId).orElse(null);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, @RequestParam(required = false) Integer quantity, HttpSession session) {
        try {
            Long userId = 1L; // Giriş sistemi yoksa sabit
            cartService.addProductToCart(userId, productId, quantity != null ? quantity : 1);
            return "redirect:/cart";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/?error=cart_error";
        }
    }

    // Test endpoint'i
    @GetMapping("/test")
    public String testCart(Model model) {
        try {
            Long userId = 1L;
            Cart cart = cartService.getCartByUserId(userId).orElse(null);
            if (cart == null) {
                // Test için basit bir sepet oluştur
                model.addAttribute("message", "Sepet oluşturuldu");
            } else {
                model.addAttribute("message", "Sepet zaten var: " + cart.getId());
            }
            return "test";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "test";
        }
    }
} 