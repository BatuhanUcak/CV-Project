# CV-Project
CV (özgeçmiş) oluşturan java programı.
# 📄 Java OOP - Dinamik PDF Özgeçmiş (CV) Üretici

Bu proje, Kırklareli Üniversitesi Yazılım Mühendisliği bölümü standartlarına uygun olarak geliştirilmiş, Java dilinin güçlü Nesne Yönelimli Programlama (OOP) prensiplerini kullanan konsol tabanlı bir PDF oluşturucu uygulamasıdır. 

Herhangi bir Grafiksel Kullanıcı Arayüzüne (GUI) ihtiyaç duymayan bu sistem; metinsel verileri, yapısal blokları ve yerel bir görseli (vesikalık fotoğraf) işleyerek saniyeler içerisinde profesyonel formata sahip bir PDF dokümanı oluşturur.

## 🎯 Projenin Amacı ve Mimari Yaklaşım

Projenin temel amacı, Java'nın çekirdek (core) yeteneklerini harici kütüphanelerle entegre ederek fonksiyonel bir ürün ortaya koymaktır. Geliştirme sürecinde **Single Responsibility (Tek Sorumluluk)** prensibine sıkı sıkıya bağlı kalınmıştır. 

Spagetti kod mimarisinden kaçınılarak program iki ana bileşene ayrılmıştır:
- **`Main.java` (Tetikleyici Sınıf):** Uygulamanın giriş noktasıdır. Sadece gerekli parametreleri hazırlayıp asıl işi yapacak olan nesneyi başlatmakla görevlidir. PDF kütüphanesinin iç işleyişinden tamamen izoledir.
- **`ResumeGenerator.java` (İş Mantığı):** Kapsülleme (Encapsulation) kurallarının uygulandığı, verileri private erişim belirleyicilerle koruyan ve PDF yaratım yaşam döngüsünü (Object Life Cycle) uçtan uca yöneten sınıftır.

## ✨ Öne Çıkan Özellikler

* **Dinamik Veri İşleme:** Öğrenci numarası, ad, soyad ve üniversite gibi veriler doğrudan nesne başlatılırken (constructor üzerinden) aktarılır.
* **Görsel Entegrasyonu (Image Processing):** Yerel dizinde bulunan bir vesikalık fotoğraf okunarak, iText kütüphanesi aracılığıyla PDF üzerindeki sayfa koordinatlarına orantılı bir şekilde yerleştirilir.
* **Yapılandırılmış İçerik:** Başlıklar, metin hizalamaları, kalın/eğik yazı tipleri algoritmik olarak oluşturulur.
* **Bellek Yönetimi:** Dosya yazma işlemi bittikten sonra `.close()` metodu ile Document ve Writer nesneleri kapatılarak bellek sızıntılarının (memory leak) önüne geçilir.
* **Gerçekçi Veri Seti:** Bilişim sektörüne (Java Backend, Gömülü Sistemler, Sistem Analistliği) uygun olarak tasarlanmış 3 farklı detaylı hayali iş deneyimi içerir.

## 🛠️ Kullanılan Teknolojiler

* **Java (JDK 11+):** Temel geliştirme dili.
* **iText 7 Core (`7.2.5`):** PDF tabanlı belge manipülasyonu ve hiyerarşik dizgi işlemleri için kullanılan açık kaynaklı modern kütüphane.
* **Maven:** Proje derleme (build), bağımlılık (dependency) yönetimi ve paketleme süreçleri için kullanıldı.
