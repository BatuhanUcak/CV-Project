public class Main {
    public static void main(String[] args) {
        // PDF işlemleri istenildiği gibi ayrı bir sınıfta yapılıyor.
        String photoPath = "vesikalik.jpeg"; // Proje dizinine bu isimde bir fotoğraf koymalısın
        String pdfDestination = "Batuhan_Ucak_Ozgecmis.pdf";

        ResumeGenerator cvGenerator = new ResumeGenerator(
                "Batuhan Ucak",
                "5250505032",
                "Kirklareli Universitesi - Yazilim Mühendisligi"
        );

        System.out.println("Özgeçmiş oluşturuluyor...");
        cvGenerator.generatePDF(pdfDestination, photoPath);
    }
}