import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PlaylistRekursif playlist = new PlaylistRekursif(5);
    playlist.tambahLagu(new Lagu("Knockin' on Heaven's Door", "Guns N' Roses", 5.36));
    playlist.tambahLagu(new Lagu("Bohemian Rhapsody", "Queen", 5.55));
    playlist.tambahLagu(new Lagu("Stairway to Heaven", "Led Zeppelin", 8.02));
    playlist.tambahLagu(new Lagu("Hotel California", "Eagles", 6.30));
    playlist.tambahLagu(new Lagu("Imagine", "John Lennon", 3.03));
    
    int pilihan = 0;

    while (pilihan != 5) {
      printMenu();
      try {
        pilihan = Integer.parseInt(readInput(scanner, "Masukkan pilihan Anda: "));
      } catch (NumberFormatException e) {
        System.out.println("Input tidak valid. Silakan masukkan angka.");
        continue;
      }

      switch (pilihan) {
        case 1 -> {
          double totalDurasi = PlaylistRekursif.totalDurasi(playlist.getLaguList(), playlist.getJumlahLagu());
          System.out.printf("Total durasi lagu = %.2f menit%n", totalDurasi);
        }
        case 2 -> {
          PlaylistRekursif.tampilkanMundur(playlist.getLaguList(), playlist.getJumlahLagu());
        }
        case 3 -> {
          // Implementasikan mencari durasi lagu terpanjang di sini
        }
        case 4 -> {
          // Lakukan pengukuran waktu eksekusi untuk setiap fungsi dengan kapasitas yang berbeda (misalnya 5, 10, 15, 20) dan tampilkan hasilnya di sini
          int[] kapasitasArray = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};
          PerformanceData[] performanceDataList = new PerformanceData[kapasitasArray.length];
          for (int i = 0; i < kapasitasArray.length; i++) {
            int kapasitas = kapasitasArray[i];
            PlaylistRekursif tempPlaylist = new PlaylistRekursif(kapasitas);
            PerformanceData performanceData = new PerformanceData(kapasitas, 0, 0, 0);
            for (int j = 0; j < kapasitas; j++) {
              tempPlaylist.tambahLagu(new Lagu("Judul " + (j + 1), "Penyanyi " + (j + 1), 180 + j * 10));
            }

            long startTime, endTime, totalTime;

            // Mengukur waktu eksekusi totalDurasi
            startTime = System.nanoTime();
            PlaylistRekursif.totalDurasi(tempPlaylist.getLaguList(), tempPlaylist.getJumlahLagu());
            endTime = System.nanoTime();
            totalTime = (endTime - startTime);
            performanceData.setTotalDurasiTime(totalTime);

            // Mengukur waktu eksekusi tampilkanMundur
            startTime = System.nanoTime();
            PlaylistRekursif.tampilkanMundur(tempPlaylist.getLaguList(), tempPlaylist.getJumlahLagu());
            endTime = System.nanoTime();
            totalTime = (endTime - startTime);
            performanceData.setTampilkanMundurTime(totalTime);

            // Mengukur waktu eksekusi cariDurasiTerpanjang
            startTime = System.nanoTime();
            PlaylistRekursif.cariDurasiTerpanjang(tempPlaylist.getLaguList(), tempPlaylist.getJumlahLagu());
            endTime = System.nanoTime();
            totalTime = (endTime - startTime);
            performanceData.setCariDurasiTerpanjangTime(totalTime);

            // Menyimpan data performa untuk kapasitas saat ini
            performanceDataList[i] = performanceData;
          }

          // Menampilkan hasil pengukuran waktu eksekusi
          System.out.printf("%-10s %-20s %-20s %-20s%n", "Kapasitas", "Total Durasi (ns)", "Tampilkan Mundur (ns)", "Cari Durasi Terpanjang (ns)");
          for (PerformanceData data : performanceDataList) {
            data.printPerformanceData();
          }
        }
        case 5 -> System.out.println("Keluar dari program.");
        default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
      }
    }
  }

  static String readInput(Scanner scanner, String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  static void printMenu() {
    System.out.println("Menu:");
    System.out.println("1. Tampilkan total durasi lagu");
    System.out.println("2. Tampilkan lagu secara mundur");
    System.out.println("3. Cari durasi lagu terpanjang");
    System.out.println("4. Total execution time setiap fungsi");
    System.out.println("5. Keluar");
  }
}