package com.example.application.controller;

import com.example.application.entity.Favorite;
import com.example.application.service.FavoriteService;
import com.example.application.service.UserService;
import com.example.application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listFavorites(Model model) {
        List<Favorite> favorites = favoriteService.getAllFavorites();
        model.addAttribute("favorites", favorites);
        return "favorites";
    }

    @GetMapping("/user/{userId}")
    public String listUserFavorites(@PathVariable Long userId, Model model) {
        List<Favorite> favorites = favoriteService.getAllFavorites().stream()
            .filter(f -> f.getUser() != null && f.getUser().getId().equals(userId))
            .toList();
        model.addAttribute("favorites", favorites);
        return "favorites";
    }

    @PostMapping("/remove/{favoriteId}")
    public String removeFavorite(@PathVariable Long favoriteId) {
        favoriteService.deleteFavorite(favoriteId);
        return "redirect:/favorites/user/1";
    }
} 