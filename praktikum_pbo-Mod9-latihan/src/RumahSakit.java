
public class RumahSakit {
    protected String namaRs;
    protected final RuanganOp[] daftarRuangan;
    Dokter[] daftarDokter;

    RumahSakit(String namaRs) {
        this.namaRs = namaRs;
        this.daftarRuangan = new RuanganOp[2];

        this.daftarRuangan[0] = new RuanganOp("R-01", 15);
        this.daftarRuangan[1] = new RuanganOp("R-02", 20);

        this.daftarDokter = new Dokter[4];
        
    }

    public void tambahDokter(Dokter dokter) {
        int i = 0;
        for (i = 0; i < daftarDokter.length; i++) {
            if (daftarDokter[i] == null) { 
                daftarDokter[i] = dokter; // Masukkan dokter ke slot kosong pertama yang ditemukan
                return; // Langsung keluar dari fungsi agar tidak mengisi slot berikutnya
            }
        }
    }

    public void tampilkanDaftarDokter() {
        boolean ada = false;

       for (int j = 0; j < daftarDokter.length; j++) {
            if (daftarDokter[j] != null) {
                System.out.println((j + 1) + ". Nama        : " + daftarDokter[j].getNamaDokter());
                System.out.println("   Spesialisasi: " + daftarDokter[j].getSpesialisasi());
                ada = true;
            }
        }
        if (ada = false) {
            System.out.println("Belum ada dokter yang ditugaskan.");
        }

    }

    public void cetakRuangan() {
        System.out.println("Nama RS : " + this.namaRs);

        for (int i = 0; i < daftarRuangan.length; i++) {
            if (daftarRuangan[i] != null) {
                System.out.println((i + 1) + ". Nomor Registrasi : " + daftarRuangan[i].getNomorRegistrasi());
                System.out.println("Kapasitas Maksimal: " + daftarRuangan[i].getKapasitasMaks() + " pasien");
            }
        }
    }
}
