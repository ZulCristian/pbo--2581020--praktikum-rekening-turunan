import java.util.Locale;

public class Rekening {
    // Ketentuan 1: nomor dan pemilik tetap private
    private String nomor;
    private String pemilik;
    protected int saldo;

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
        return "Rp" + String.format(Locale.GERMANY, "%,d", angka);
    }
}