public class Lagu {
    private String judul;
    private String artis;
    private double durasi;

    // Constructor
    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Getter methods
    public String getJudul() {
        return judul;
    }

    public String getArtis() {
        return artis;
    }

    public double getDurasi() {
        return durasi;
    }
}
