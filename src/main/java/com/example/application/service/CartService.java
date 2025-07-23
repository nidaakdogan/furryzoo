package com.example.application.service;

import com.example.application.entity.Cart;
import com.example.application.entity.CartItem;
import com.example.application.entity.Product;
import com.example.application.entity.User;
import com.example.application.repository.CartItemRepository;
import com.example.application.repository.CartRepository;
import com.example.application.repository.ProductRepository;
import com.example.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    public Optional<Cart> getCartByUserId(Long userId) {
        return Optional.ofNullable(cartRepository.findByUserId(userId));
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    public void addProductToCart(Long userId, Long productId, int quantity) {
        // Önce kullanıcıyı kontrol et
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            System.out.println("Kullanıcı bulunamadı: " + userId);
            return;
        }
        
        // Ürünü kontrol et
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            System.out.println("Ürün bulunamadı: " + productId);
            return;
        }
        
        // Sepeti bul veya oluştur
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setItems(new java.util.HashSet<>());
            cart = cartRepository.save(cart);
            System.out.println("Yeni sepet oluşturuldu: " + cart.getId());
        }
        
        // Sepete ürün ekle
        CartItem newItem = new CartItem();
        newItem.setCart(cart);
        newItem.setProduct(product);
        newItem.setQuantity(quantity);
        
        cart.getItems().add(newItem);
        cartRepository.save(cart);
        
        System.out.println("Ürün sepete eklendi: " + product.getName());
    }
} 