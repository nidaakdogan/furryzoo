package com.example.application.controller;

import com.example.application.entity.Review;
import com.example.application.entity.Product;
import com.example.application.entity.User;
import com.example.application.service.ReviewService;
import com.example.application.service.ProductService;
import com.example.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String listReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "reviews";
    }

    @GetMapping("/product/{productId}")
    public String listProductReviews(@PathVariable Long productId, Model model) {
        List<Review> reviews = reviewService.getAllReviews().stream()
            .filter(r -> r.getProduct() != null && r.getProduct().getId().equals(productId))
            .toList();
        model.addAttribute("reviews", reviews);
        model.addAttribute("productId", productId);
        // Kullanıcı oturumu yoksa userId null gönder
        model.addAttribute("userId", 1); // örnek: userId=1 (giriş sistemi eklenince dinamik yapılacak)
        return "reviews";
    }

    @PostMapping("/add")
    public String addReview(@RequestParam int rating, @RequestParam String comment, @RequestParam Long productId, @RequestParam Long userId) {
        Product product = productService.getProductById(productId).orElse(null);
        User user = userService.getUserById(userId).orElse(null);
        if (product != null && user != null) {
            Review review = new Review();
            review.setProduct(product);
            review.setUser(user);
            review.setRating(rating);
            review.setComment(comment);
            review.setCreatedAt(LocalDateTime.now());
            reviewService.saveReview(review);
        }
        return "redirect:/reviews/product/" + productId;
    }
} 