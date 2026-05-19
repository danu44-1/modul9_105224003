public class KomputerServer { // Penerapan Komposisi
    String penyimpanan;
    String komp;

    KomputerServer(String komponen, String penyimpan) {
        this.penyimpanan = penyimpan;
        this.komp = new Harddisk(komponen); // penerapan komposisi dengan hardisk sebagai komponen dari komputer server namun erro gagal
    }
}
