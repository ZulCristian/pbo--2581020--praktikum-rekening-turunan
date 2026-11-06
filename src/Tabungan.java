public class Tabungan extends Rekening { //Tabungan mewarisi atribut dan method dari Rekening,
                                         // sehingga tidak perlu membuat ulang kode yang sudah ada.
    private double bungaPersen; //Digunakan untuk menyimpan persentase bunga tabungan, misalnya 2,5%.
                                // Tipe double digunakan karena nilainya bisa berupa desimal.

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    public int tambahBunga() {
        int bunga = (int) Math.round(saldo * bungaPersen / 100);
        setor(bunga);
        return bunga;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("      Tabungan, bunga " + bungaPersen + "% per bulan");
    }
}