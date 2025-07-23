# 🐾 Furryzoo

**Furryzoo**, evcil hayvanlara özel mama, oyuncak ve aksesuarların yer aldığı bir konsept e-ticaret platformudur.  
Kullanıcı dostu ve sevimli bir alışveriş deneyimi sunmak amacıyla geliştirilmiştir.

---

## 🚀 Özellikler

- 🐱 **Kategori bazlı ürün listeleme** (Kedi/Köpek ürünleri)
- 🌸 **Thymeleaf ile dinamik sayfa oluşturma**
- 🌸 **Spring Boot tabanlı MVC mimarisi**
- 📄 **HTML + CSS ile frontend tasarım**
- 📗 **Blog ve bilgilendirici içerik sayfaları**

---

## 🔧 Geliştirme Aşamasındaki Özellikler

- 🛒 **Sepet yönetimi** (Ürün ekleme & sepeti görüntüleme)
- 📦 **Sipariş oluşturma ve yönetimi**
- 🔐 **Kullanıcı kayıt/giriş sistemi** (Spring Security ile)

---

## 🧠 Planlanan Özellikler

- 🔍 Ürün arama ve filtreleme
- ⭐ Ürün değerlendirme ve yorum ekleme
- 🚚 Sipariş durumu takip modülü
- 📧 E-posta ile sipariş ve bildirim desteği


---

## 🛠 Kullanılan Teknolojiler

| Katman           | Teknoloji                              |
|------------------|-----------------------------------------|
| Backend          | Java, Spring Boot                       |
| Frontend         | HTML, CSS, Thymeleaf, Bootstrap         |
| Veritabanı       | H2 (In-Memory)                          |
| Güvenlik         | Spring Security                         |
| Test             | JUnit                                   |
| Build Tool       | Maven                                   |
| Versiyon Kontrol | Git & GitHub                            |

---

## 📁 Proje Yapısı

- `src/main/java/`
  - `com.example.application/`
    - `controller/` → Controller (web layer) sınıfları
    - `service/` → İş mantığı (business logic) sınıfları
    - `entity/` → JPA Entity (veritabanı modeli) sınıfları
    - `repository/` → Spring Data JPA repository arayüzleri
- `src/main/resources/`
  - `templates/` → HTML şablonları (Thymeleaf)
  - `static/` → Statik dosyalar (CSS, JS, görseller)
  - `application.properties` → Uygulama ayarları
- `pom.xml` → Maven bağımlılık ve proje konfigürasyonu
- `README.md` → Proje açıklaması ve dokümantasyon

  ## ▶️ Uygulamayı Başlatma

Projenizi çalıştırmak için terminalde aşağıdaki komutları sırasıyla çalıştırın:

```bash
cd my-app && mvn spring-boot:run
