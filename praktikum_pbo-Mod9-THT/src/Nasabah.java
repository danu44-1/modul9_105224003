public class Nasabah {
    private Rekening[] rekening;  
    private String nama;

    Nasabah(String nama) {
        this.rekening = new Rekening[3]; // aggregasi, dengan nasabah yang memiliki rekening sebagai bagian dari menjadi nasabah
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public Rekening[] getRekening() {
        return rekening;
    }

    public void tambahRekening(Rekening rek) { // hubungan aggregasi yang juga bisa menambah rekening melalui bagian dari menjadi nasabah
        int jumlah = 0;

        if (jumlah < 3) {
            rekening[jumlah] = rek;
            System.out.println("Rekening " + rek.getNomorRekening() + " berhasil ditambahkan ke profil " + nama);
            jumlah++;
        } else {
            System.out.println("Gagal: Maksimal 3 rekening.");
        }
    }

    public void hubungiCS(CustomerService cs, String keluhan) {
        cs.layaniKeluhan(this.nama, keluhan); // hubungan Asosiasi dan kedua objek berdiri sendiri, namun dapat saling berinteraksi
    }
}
