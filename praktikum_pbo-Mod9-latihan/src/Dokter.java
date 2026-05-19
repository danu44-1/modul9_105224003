public class Dokter {
    protected String namaDokter;
    protected String spesialisasi;

    Dokter(String namaDokter, String spesialisasi) {
        this.namaDokter = namaDokter;
        this.spesialisasi = spesialisasi;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void periksaPasien (Pasien pasien) {
        System.out.println("Nama Dokter yang memeriksa : " + this.namaDokter);
        System.out.println("Spesialisasi : " + this.spesialisasi);
        System.out.println("Nama Pasien : " + pasien.nama);
        System.out.println("Umur Pasien : " + pasien.umur);
        System.out.println("Status : Selesai diperiksa.\n");
    }
}
