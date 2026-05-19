public class Montir {
    protected String idMontir;
    protected String nama;

    Montir(String idMontir, String nama) {
        this.idMontir = idMontir;
        this.nama = nama;
    }

    public void lakukanQualityControl(Mobil m) {
        System.out.println("Merk Mobil : " + m.getMerkMobil());
        System.out.println("Warna Mobil : " + m.getWarna());
        System.out.println("Mesin Mobil : " + m.getMesin());
        System.out.println("Diperiksa...");
    }
}
