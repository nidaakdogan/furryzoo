package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        try {
            // Uygulama başlatıldıktan sonra ana sayfayı aç
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI("http://localhost:9090"));
            }
        } catch (Exception e) {
            System.out.println("Tarayıcı otomatik açılamadı: " + e.getMessage());
        }
}
}