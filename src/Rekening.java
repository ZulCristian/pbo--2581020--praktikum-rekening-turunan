import java.util.Locale;

public class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;  //private hanya bisa diakses di dalam class Rekening,
                          //sedangkan protected bisa diakses oleh class turunannya,yaitu Tabungan dan Giro.
                          //Jadi, class Giro bisa mengubah saldo secara langsung,
                          //termasuk membuat saldo menjadi minus saat penarikan.

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    public void cetakInfo() {
        System.out.printf("%s | %-6s | %12s%n", nomor, pemilik, formatRupiah(saldo));
    }

    protected static String formatRupiah(int angka) {
        //Fungsi protected: Membuat method formatRupiah() bisa digunakan oleh class turunannya,
        // seperti Giro, untuk menampilkan jumlah uang.
        //Fungsi static: Method ini bisa dipanggil langsung menggunakan nama class Rekening,
        // tanpa harus membuat objek terlebih dahulu. Contohnya, Rekening.formatRupiah(25000).
        return "Rp" + String.format(Locale.GERMANY, "%,d", angka);
    }
}