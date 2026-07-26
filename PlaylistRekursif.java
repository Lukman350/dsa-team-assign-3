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

  public double totalDurasi(int n) {
    if (n == 0) {
      return 0;
    }

    return laguList[n - 1].getDurasi() + totalDurasi(n - 1);
  }
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

  public Lagu cariDurasiTerpanjang(int index) {
    // implementasi fungsi cariDurasiTerpanjang disini
    return null;
  }

  public int getJumlahLagu() {
    return jumlahLagu;
  }
}
