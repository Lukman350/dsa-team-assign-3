/*
 * =====================================================================
 * Tugas Kelompok 3 - COSC6025 Data Structures and Algorithm Analysis
 * Topik   : Algorithmic Analysis, Mathematical Induction, and Recursive Functions
 *
 * Anggota Kelompok:
 *  1. <ISI NAMA LENGKAP>   - <ISI NIM>
 *  2. <ISI NAMA LENGKAP>   - <ISI NIM>
 *  3. <ISI NAMA LENGKAP>   - <ISI NIM>
 * Kelas   : <ISI KELAS>
 * =====================================================================
 * TODO: Ganti placeholder di atas dengan data anggota kelompok yang sebenarnya
 * sebelum dikumpulkan.
 */
public class PlaylistRekursif {
  private final Lagu[] laguList;
  private int jumlahLagu;

  public PlaylistRekursif(int kapasitas) {
    this.laguList = new Lagu[kapasitas];
    this.jumlahLagu = 0;
  }

  public void tambahLagu(Lagu lagu) {
    if (jumlahLagu < laguList.length) {
      laguList[jumlahLagu] = lagu;
      jumlahLagu++;
    } else {
      System.out.println("Playlist penuh. Tidak dapat menambahkan lagu baru.");
    }
  }

  /**
   * Tujuan: Menghitung total durasi semua lagu dalam playlist.
   * Base Case: Jika n == 0, berarti tidak ada lagu yang tersisa untuk dijumlahkan, sehingga mengembalikan 0.
   * Recursive Case: Menambahkan durasi lagu terakhir (list[n - 1]) ke total durasi dari sisa lagu (totalDurasi(list, n - 1)).
   * Kompleksitas Waktu: O(n) - Linear, karena fungsi memanggil dirinya sendiri sebanyak n kali/jumlah lagu.
   */
  public static double totalDurasi(Lagu[] list, int n) {
    if (n == 0) {
      return 0;
    }
    return list[n - 1].getDurasi() + totalDurasi(list, n - 1);
  }
  
  /**
   * Tujuan: Menampilkan daftar lagu secara terbalik dari akhir ke awal.
   * Base Case: Jika index == 0, iterasi berhenti karena sudah mencapai awal array.
   * Recursive Case: Mencetak lagu pada index saat ini, lalu memanggil dirinya sendiri dengan index - 1.
   * Kompleksitas Waktu: O(n) - Linear, karena fungsi memanggil dirinya sendiri sebanyak n kali/jumlah lagu.
   */
  public static void tampilkanMundur(Lagu[] list, int index) {
    // Base case
    if (index == 0) {
        return; 
    }
    
    // Recursive case
    System.out.println(index + ". " + list[index - 1].getJudul() + " - " + list[index - 1].getArtis() + " (" + list[index - 1].getDurasi() + " menit)");
    
    // Memanggil fungsi itu lagi dengan index berkurang 1
    tampilkanMundur(list, index - 1);
  }

    /**
   * Tujuan: Mencari durasi lagu terpanjang dalam playlist.
   * Base Case: Jika index == 0, mengembalikan 0.
   * Recursive Case: Membandingkan durasi lagu saat ini dengan hasil sebelumnya.
   * Kompleksitas Waktu: O(n) dengan growth rate linear.
   */
  public static double cariDurasiTerpanjang(Lagu[] list, int index) {
    if (index == 0) {
      return 0.0;
    }

    double maksimumSebelumnya =
        cariDurasiTerpanjang(list, index - 1);

    return Math.max(list[index - 1].getDurasi(), maksimumSebelumnya);
  }

  public int getJumlahLagu() {
    return jumlahLagu;
  }

  public Lagu[] getLaguList() {
      return laguList;
  }
}
