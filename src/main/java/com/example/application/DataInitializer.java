package com.example.application;

import com.example.application.repository.UserRepository;
import com.example.application.repository.ProductRepository;
import com.example.application.repository.CategoryRepository;
import com.example.application.entity.User;
import com.example.application.entity.Product;
import com.example.application.entity.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner loadData(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository, PasswordEncoder encoder) {
        return args -> {
            // Kategorileri ekle
            Category mama = new Category();
            mama.setName("Mama");
            mama.setDescription("Evcil hayvan mamaları");
            categoryRepository.save(mama);

            Category oyuncak = new Category();
            oyuncak.setName("Oyuncak");
            oyuncak.setDescription("Evcil hayvan oyuncakları");
            categoryRepository.save(oyuncak);

            Category aksesuar = new Category();
            aksesuar.setName("Aksesuar");
            aksesuar.setDescription("Evcil hayvan aksesuarları");
            categoryRepository.save(aksesuar);

            Category bakim = new Category();
            bakim.setName("Bakım");
            bakim.setDescription("Evcil hayvan bakımı ürünleri");
            categoryRepository.save(bakim);

            // Kullanıcı ekle
            if (userRepository.findByEmail("test@furryzoo.com") == null) {
                User testUser = new User("test@furryzoo.com", encoder.encode("test123"));
                testUser.setFirstName("Test");
                testUser.setLastName("User");
                userRepository.save(testUser);
            }

            // Ürünleri kategorilere bağla
            if (productRepository.count() == 0) {
                // Mama ürünleri
                Product kopekMamasi = new Product("Premium Köpek Maması", 1499.99, "Sağlıklı ve lezzetli, tüm ırklar için");
                kopekMamasi.setCategory(mama);
                kopekMamasi.setImageUrl("/dog-food.png");
                productRepository.save(kopekMamasi);

                Product kediMamasi = new Product("Doğal Kedi Maması", 799.99, "Taze içerik, yüksek protein");
                kediMamasi.setCategory(mama);
                kediMamasi.setImageUrl("/cat-food.png");
                productRepository.save(kediMamasi);

                Product yavruKediMamasi = new Product("Yavru Kedi Maması", 599.99, "Yavru kediler için özel formül");
                yavruKediMamasi.setCategory(mama);
                yavruKediMamasi.setImageUrl("/puppy-food.png");
                productRepository.save(yavruKediMamasi);

                Product hypoallergenicMamasi = new Product("Hypoallergenic Mama", 999.99, "Alerjisi olan evcil dostlar için mama");
                hypoallergenicMamasi.setCategory(mama);
                hypoallergenicMamasi.setImageUrl("/hypoallergenic-food.png");
                productRepository.save(hypoallergenicMamasi);

                Product tahilsizMamasi = new Product("Tahılsız Mama", 1099.99, "Tahılsız, yüksek proteinli mama");
                tahilsizMamasi.setCategory(mama);
                tahilsizMamasi.setImageUrl("/grainfree-food.png");
                productRepository.save(tahilsizMamasi);

                Product lightMamasi = new Product("Light Mama", 899.99, "Kilo kontrolü için düşük kalorili mama");
                lightMamasi.setCategory(mama);
                lightMamasi.setImageUrl("/light-food.png");
                productRepository.save(lightMamasi);

                Product somonluMamasi = new Product("Somonlu Kedi Maması", 849.99, "Somonlu, omega-3 destekli mama");
                somonluMamasi.setCategory(mama);
                somonluMamasi.setImageUrl("/salmon-cat-food.png");
                productRepository.save(somonluMamasi);

                Product kuzuluMamasi = new Product("Kuzulu Köpek Maması", 1299.99, "Kuzulu, hassas sindirim için mama");
                kuzuluMamasi.setCategory(mama);
                kuzuluMamasi.setImageUrl("/lamb-dog-food.png");
                productRepository.save(kuzuluMamasi);

                Product tavukluMamasi = new Product("Tavuklu Kedi Maması", 749.99, "Tavuklu, vitamin destekli mama");
                tavukluMamasi.setCategory(mama);
                tavukluMamasi.setImageUrl("/chicken-cat-food.png");
                productRepository.save(tavukluMamasi);

                // Oyuncak ürünleri
                Product oyuncak1 = new Product("Köpek Oyuncağı", 199.99, "Dayanıklı köpek oyuncağı");
                oyuncak1.setCategory(oyuncak);
                oyuncak1.setImageUrl("/toy-dog.png");
                productRepository.save(oyuncak1);

                Product oyuncak2 = new Product("Kedi Topu", 49.99, "Zilli kedi topu, eğlenceli ve güvenli");
                oyuncak2.setCategory(oyuncak);
                oyuncak2.setImageUrl("/toy-cat-ball.png");
                productRepository.save(oyuncak2);

                Product oyuncak3 = new Product("Kedi Tırmalama Tahtası", 299.99, "Kediler için tırmalama ve oyun alanı");
                oyuncak3.setCategory(oyuncak);
                oyuncak3.setImageUrl("/toy-scratcher.png");
                productRepository.save(oyuncak3);

                Product oyuncak4 = new Product("Kedi Tüy Çubuğu", 39.99, "Kediler için tüy çubuklu oyuncak");
                oyuncak4.setCategory(oyuncak);
                oyuncak4.setImageUrl("/toy-feather.png");
                productRepository.save(oyuncak4);

                Product oyuncak5 = new Product("Köpek Halat Oyuncağı", 89.99, "Çekiştirmeli köpek oyuncağı");
                oyuncak5.setCategory(oyuncak);
                oyuncak5.setImageUrl("/toy-rope.png");
                productRepository.save(oyuncak5);

                // Bakım ürünleri
                Product bakim1 = new Product("Tüy Tarağı", 59.99, "Kedi ve köpekler için tüy tarağı");
                bakim1.setCategory(bakim);
                bakim1.setImageUrl("/groom-brush.png");
                productRepository.save(bakim1);

                Product bakim2 = new Product("Köpek Şampuanı", 79.99, "Hassas ciltler için köpek şampuanı");
                bakim2.setCategory(bakim);
                bakim2.setImageUrl("/dog-shampoo.png");
                productRepository.save(bakim2);

                Product bakim3 = new Product("Kedi Şampuanı", 69.99, "Kediler için özel şampuan");
                bakim3.setCategory(bakim);
                bakim3.setImageUrl("/cat-shampoo.png");
                productRepository.save(bakim3);

                Product bakim4 = new Product("Tırnak Makası", 34.99, "Evcil hayvanlar için tırnak makası");
                bakim4.setCategory(bakim);
                bakim4.setImageUrl("/nail-clipper.png");
                productRepository.save(bakim4);

                // Aksesuar ürünleri
                Product tasma = new Product("Tasma", 899.99, "Ayarlanabilir, dayanıklı ve şık");
                tasma.setCategory(aksesuar);
                tasma.setImageUrl("/collar.png");
                productRepository.save(tasma);

                Product mamaKabi = new Product("Mama Kabı", 49.99, "Kaymaz tabanlı mama kabı");
                mamaKabi.setCategory(aksesuar);
                mamaKabi.setImageUrl("/bowl.png");
                productRepository.save(mamaKabi);

                Product suKabi = new Product("Su Kabı", 39.99, "Paslanmaz çelik su kabı");
                suKabi.setCategory(aksesuar);
                suKabi.setImageUrl("/water-bowl.png");
                productRepository.save(suKabi);

                Product tasimaCantasi = new Product("Taşıma Çantası", 299.99, "Kedi ve köpekler için taşıma çantası");
                tasimaCantasi.setCategory(aksesuar);
                tasimaCantasi.setImageUrl("/carrier.png");
                productRepository.save(tasimaCantasi);

                Product patiKiyafeti = new Product("Pati Kıyafeti", 119.99, "Küçük ırklar için sevimli kıyafet");
                patiKiyafeti.setCategory(aksesuar);
                patiKiyafeti.setImageUrl("/pet-clothes.png");
                productRepository.save(patiKiyafeti);
            }
        };
    }
} 