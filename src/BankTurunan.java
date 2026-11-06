public class BankTurunan {
    private static void hasil(String label, boolean berhasil) {
        System.out.printf("%-26s: %s%n", label, berhasil ? "Berhasil" : "Ditolak");
    }

    public static void main(String[] args) {
        Tabungan ani = new Tabungan("101", "Ani", 1_000_000, 2.5);
        Giro budi    = new Giro("201", "Budi", 200_000, 500_000);

        System.out.println("========== REKENING AWAL ==========");
        ani.cetakInfo();
        budi.cetakInfo();

        System.out.println();
        System.out.println("============ TRANSAKSI ============");
        hasil("Tabungan tarik 1.500.000", ani.tarik(1_500_000));
        hasil("Giro tarik 500.000",       budi.tarik(500_000));
        hasil("Giro tarik 300.000",       budi.tarik(300_000));
        hasil("Giro setor 100.000",       budi.setor(100_000));   // setor mengembalikan boolean
        int bunga = ani.tambahBunga();
        System.out.printf("%-26s: %s%n", "Bunga tabungan", Rekening.formatRupiah(bunga));

        System.out.println();
        System.out.println("========== REKENING AKHIR =========");
        ani.cetakInfo();
        budi.cetakInfo();
    }
}