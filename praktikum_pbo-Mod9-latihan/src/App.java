public class App {
    public static void main(String[] args) throws Exception {
        Dokter dokter1 = new Dokter("Putra", "Spesialisasi Jantung");
        Dokter dokter2 = new Dokter("Putro", "Spesialisasi Nafas");
        Pasien pasien1 = new Pasien("Ogi", 56);
        Pasien pasien2 = new Pasien("Joe", 57);

        dokter1.periksaPasien(pasien1);

        RumahSakit rs = new RumahSakit("RS Sehat Selalu");

        rs.tambahDokter(dokter1);
        rs.tambahDokter(dokter2);

        rs.tampilkanDaftarDokter();

        
        rs = null;
        
        rs.cetakRuangan();

        System.out.println("Dokter 1 : " + dokter1.getNamaDokter());
        System.out.println("Dokter 2 : " + dokter2.getNamaDokter());

        // entitas yang masih ada adalah si dokter 1 dan 2 namun complier saat tes menghentikan saat error karena RS di hapus (null).
        // entitas yang pasti hilang adalah rumah sakitnya dan ruangannya, karena ruangan berbentuk final dengan hubungan komposisi.
        
        
    }
}
