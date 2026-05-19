public class Main {
    public static void main(String[] args) throws Exception {
        Ban ban1 = new Ban("Modulo", 50);
        Ban ban2 = new Ban("Modulo", 50);
        Ban ban3 = new Ban("Modulo", 50);
        Ban ban4 = new Ban("Modulo", 50);

        Ban setBan[] = {ban1, ban2, ban3, ban4};

        Mobil mobil1 = new Mobil("Kijang Super", "Red Classic", "RHB 101", 40000);

        mobil1.pasangSetBan(setBan);
        Montir orang = new Montir("4444", "Jhin");

        orang.lakukanQualityControl(mobil1);

        System.out.println("Hasil QC : Gagal Uji Kelayakan, Dihancurkan");
        mobil1 = null;

        for (Ban ban : setBan) { // dipanggil dengan methodnya karena class independen
            ban.gudang();
        }

        mobil1.tampilkanSpesifikasi(); // pemanggilan method yang memiliki entitas mesin dari objek mobil setelah null hasilnya akan null, membuktikan bahwa entitas mesin telah musnah karena hubungan Composition dengan mobil.
        
        // sedangkan entitas ban masih tetap selamat karena classnya independen dan dapat dipanggil dengan methodnya
    }
}
