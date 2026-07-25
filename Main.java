
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PlaylistRekursif playlist = new PlaylistRekursif(5);
    playlist.tambahLagu(new Lagu());
    playlist.tambahLagu(new Lagu());
    playlist.tambahLagu(new Lagu());
    playlist.tambahLagu(new Lagu());
    playlist.tambahLagu(new Lagu());
    
    int pilihan = 0;

    while (pilihan != 4) {
      printMenu();
      try {
        pilihan = Integer.parseInt(readInput(scanner, "Masukkan pilihan Anda: "));
      } catch (NumberFormatException e) {
        System.out.println("Input tidak valid. Silakan masukkan angka.");
        continue;
      }

      switch (pilihan) {
        case 1 -> {
          double totalDurasi = playlist.totalDurasi(playlist.getJumlahLagu());
          System.out.printf("Total durasi lagu = %.2f menit%n", totalDurasi / 60);
        }
        case 2 -> {
          // implementasi menampilkan lagu secara mundur di sini
        }
        case 3 -> {
          // Implementasikan mencari durasi lagu terpanjang di sini
        }
        case 4 -> System.out.println("Keluar dari program.");
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
    System.out.println("4. Keluar");
  }
}