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
        System.out.println(index + ". " + list[index - 1].getJudul());
        
        // Memanggil fungsi itu lagi dengan index berkurang 1
        tampilkanMundur(list, index - 1);
    }

  public static double cariDurasiTerpanjang(Lagu[] list, int index) {
    // implementasi fungsi cariDurasiTerpanjang disini
    return null;
  }

  public int getJumlahLagu() {
    return jumlahLagu;
  }

  public Lagu[] getLaguList() {
      return laguList;
  }
}
