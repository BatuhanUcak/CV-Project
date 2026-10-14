import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class ResumeGenerator {

    // Kapsülleme (Encapsulation) için private erişim düzenleyiciler
    private String nameSurname;
    private String studentId;
    private String university;

    // Kurucu Metot (Constructor)
    public ResumeGenerator(String nameSurname, String studentId, String university) {
        this.nameSurname = nameSurname;
        this.studentId = studentId;
        this.university = university;
    }

    // PDF Üretim Metodu
    public void generatePDF(String dest, String imagePath) {
        try {
            // 1. PDF Yazıcı ve Doküman nesnelerinin oluşturulması
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // 2. Başlık Ekleme
            Paragraph title = new Paragraph("KISISEL OZGECMIS (CV)")
                    .setBold()
                    .setFontSize(18)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));

            // 3. Fotoğraf Ekleme
            try {
                ImageData data = ImageDataFactory.create(imagePath);
                Image img = new Image(data);
                img.setWidth(120);
                img.setHeight(120);
                img.setHorizontalAlignment(com.itextpdf.layout.properties.HorizontalAlignment.CENTER);
                document.add(img);
            } catch (MalformedURLException e) {
                document.add(new Paragraph("[HATA: Fotoğraf bulunamadı veya yüklenemedi. Lütfen dizini kontrol edin.]").setItalic());
            }

            document.add(new Paragraph("\n"));

            // 4. Kişisel Bilgiler
            document.add(new Paragraph("KISISEL BILGILER").setBold().setFontSize(14));
            document.add(new Paragraph("Ad Soyad: " + nameSurname));
            document.add(new Paragraph("Ogrenci Numarasi: " + studentId));
            document.add(new Paragraph("Egitim: " + university));
            document.add(new Paragraph("\n"));

            // 5. İş Deneyimleri (İstenen 3 Hayali Deneyim)
            document.add(new Paragraph("IS DENEYIMLERI").setBold().setFontSize(14));

            document.add(new Paragraph(" 1. Gomulu Sistemler ve Yapay Zeka Mimari (Lead Embedded AI Engineer) –")
                    .setBold());
            document.add(new Paragraph(" – Global Bir Elektrikli Araç (EV) Üreticisi\n" +
                    "Kariyerinin en heyecan verici ve teknik anlamda en doyurucu adimlarindan biri, otonom surus ve elektrikli arac teknolojilerinde oncu global bir firmada (ornegin Tesla veya Rivian gibi bir sirketin Ar-Ge merkezinde) Gomulu Sistemler Yapay Zeka Mimari olarak gorev almak olabilir. Bu rolde, araclarin Batarya Yonetim Sistemleri (BMS) uzerinde calisarak olasi yangin veya asiri isinma risklerini daha olusmadan tespit eden, bulanik mantik (fuzzy logic) tabanli akilli donanim kitlerinin yazilimlarini gelistiriyorsun. Saf C ve C++ kullanarak donanima en yakin seviyede, mikrodenetleyiciler (ornegin gelismis Raspberry Pi veya ARM tabanli mimariler) uzerinde calisan algoritmalar insa ediyorsun. Ozellikle TinyML (Tiny Machine Learning) teknolojilerini kullanarak, buyuk boyutlu yapay zeka tensorlerini 32-bit kayan noktali sayilardan (float) 8-bit tam sayilara (integer) sikistirarak bellek optimizasyonu yapiyor ve arac ici sistemlerin milisaniyeler icinde karar vermesini sagliyorsun. Hem donanim kisitlamalariyla mucadele ettigin hem de yazdigin C kodlarinin gercek dunyada fiziksel bir aracin guvenligini sagladigi bu pozisyon, muhendislik yeteneklerinin zirvesi niteliginde."));

            document.add(new Paragraph("\n2.Kidemli Altyapi ve Arka Uc Muhendisi (Senior Infrastructure & Backend Engineer)")
                    .setBold());
            document.add(new Paragraph("- Ikinci hayali deneyimin, milyonlarca anlik oyuncuya ve devasa bir sanal ekonomiye sahip devasa bir oyun ve sanal evren platformunun cekirdek sunucu ekibinde gorev almaktır. Bu pozisyonda, dunya capindaki milyonlarca oyuncunun sunuculara gonderdigi devasa veri trafigini yoneten ve onceliklendiren, RFC standartlarina tam uyumlu yuksek performansli API Gateway sistemlerinin mimarisini bastan asagi tasarliyorsun. Sistemdeki darbogazlari (bottleneck) engellemek icin C++ tabanli, Min-Heap oncelik kuyruklari ve son derece optimize edilmis Hash Table veri yapilarini kullanarak saniyede milyonlarca istegi (request) yonlendiren mikroservisler yaziyorsun. Ayni zamanda, sunuculardaki anlik hatalari ve loglari (Linux syslog) gercek zamanli olarak okuyup anlamlandiran, bagli liste (linked list) tabanli ozel log isleme motorlari gelistiriyorsun. Bu rol, oyun dunyasina olan ilgini, dusuk seviyeli algoritma bilginle birlestirerek devasa sistemlerin ayakta kalmasini saglayan \"gizli kahraman\" olmani sagliyor.."));

            document.add(new Paragraph("\n3.Bas Spor Teknolojileri ve Veri Analitigi Gelistiricisi (Lead Sports Tech Developer) – Uluslararasi Voleybol Federasyonu (FIVB) Inovasyon Merkezi ")
                    .setBold());
            document.add(new Paragraph("- Ucuncu ve kisisel tutkularini en cok yansitan deneyim ise, FIVB catisi altinda veya global bir spor analitigi firmasinda (ornegin VolleyTech Analytics) Bas Gelistirici olmak. Hem voleybolun taktiksel dunyasini (pasor ve smacor dinamikleri) cok iyi bilen hem de gorsel tasarim/video isleme yetenekleri olan bir yazilim muhendisi olarak, sahadaki taktiksel dizilisleri gercek zamanli analiz eden bir yazilim ekosistemi kuruyorsun. Ozellikle 5-1 hucum rotasyonlarindaki pozisyon hatalarini, pasorlerin top dagitim istatistiklerini ve smacorlerin Asics/Mizuno gibi profesyonel ayakkabilarla yaptiklari sicrama mekaniklerini (biyomekanik veriler) kameralar araciligiyla isleyen yapay zeka destekli bir video analiz araci gelistiriyorsun. Gelistirdigin bu sistem, mac aninda video karelerini isleyerek (CapCut veya benzeri profesyonel video kurgu algoritmalarinin mantigini kullanarak) antrenorlerin tabletlerine anlik taktiksel gorseller, sahanin isi haritalari ve sosyal medya hesaplari icin otomatik 9:16 oraninda dinamik mac istatistikleri grafikleri gonderiyor. Yazilimi, sporu ve tasarimi tek bir cati altinda birlestirdigim bu is, benim icin bir meslekten cok bir yasam tarzi haline geliyor.."));

            // Bellek sızıntılarını önlemek için doküman nesnesini kapatıyoruz
            document.close();

            System.out.println("Başarılı! PDF Özgeçmiş dizine kaydedildi: " + dest);

        } catch (FileNotFoundException e) {
            System.out.println("PDF dosyası oluşturulurken hata meydana geldi: " + e.getMessage());
        }
    }
}