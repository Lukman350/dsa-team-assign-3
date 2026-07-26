public class PerformanceData {
  private int kapasitas;
  private long totalDurasiTime;
  private long tampilkanMundurTime;
  private long cariDurasiTerpanjangTime;

  public PerformanceData(int kapasitas, long totalDurasiTime, long tampilkanMundurTime, long cariDurasiTerpanjangTime) {
    this.kapasitas = kapasitas;
    this.totalDurasiTime = totalDurasiTime;
    this.tampilkanMundurTime = tampilkanMundurTime;
    this.cariDurasiTerpanjangTime = cariDurasiTerpanjangTime;
  }

  public int getKapasitas() {
    return kapasitas;
  }

  public long getTotalDurasiTime() {
    return totalDurasiTime;
  }

  public long getTampilkanMundurTime() {
    return tampilkanMundurTime;
  }

  public long getCariDurasiTerpanjangTime() {
    return cariDurasiTerpanjangTime;
  }

  public void setKapasitas(int kapasitas) {
    this.kapasitas = kapasitas;
  }

  public void setTotalDurasiTime(long totalDurasiTime) {
    this.totalDurasiTime = totalDurasiTime;
  }

  public void setTampilkanMundurTime(long tampilkanMundurTime) {
    this.tampilkanMundurTime = tampilkanMundurTime;
  }

  public void setCariDurasiTerpanjangTime(long cariDurasiTerpanjangTime) {
    this.cariDurasiTerpanjangTime = cariDurasiTerpanjangTime;
  }

  public void printPerformanceData() {
    System.out.printf("%-10d %-20d %-20d %-20d%n", kapasitas, totalDurasiTime, tampilkanMundurTime, cariDurasiTerpanjangTime);
  }
}