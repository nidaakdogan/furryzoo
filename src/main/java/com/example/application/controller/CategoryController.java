package com.example.application.controller;

import com.example.application.entity.Category;
import com.example.application.entity.Product;
import com.example.application.repository.CategoryRepository;
import com.example.application.repository.ProductRepository;
import com.example.application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category-form";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    // Kategoriye tıklanınca ürünleri listele
    @GetMapping("/{id}")
    public String kategoriUrunleri(@PathVariable Long id, Model model) {
        Category kategori = categoryRepository.findById(id).orElse(null);
        if (kategori == null) {
            return "redirect:/";
        }
        List<Product> urunler = productRepository.findAll().stream()
            .filter(p -> p.getCategory() != null && p.getCategory().getId().equals(id))
            .toList();
        model.addAttribute("kategori", kategori);
        model.addAttribute("urunler", urunler);
        return "kategori-urunleri";
    }
} 