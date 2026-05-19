public class Mobil {
    protected String merkMobil;
    protected String warna;
    protected final Mesin mesin;
    protected Ban[] ban;

    Mobil(String merk, String warna, String nomorSeri, int kapasitasCC) {
        this.merkMobil = merk;
        this.warna = warna;
        this.mesin = new Mesin(nomorSeri, kapasitasCC); // hubungan composition yg langsung diinstansiasi
        this.ban = new Ban[4]; // aggregation
    }

    public String getMerkMobil() {
        return merkMobil;
    }

    public String getWarna() {
        return warna;
    }

    public Mesin getMesin() {
        return mesin;
    }

    public void pasangSetBan(Ban[] setBan) { // aggregation
        if (setBan.length >= 4) {
            System.out.println("Jumlah ban melebihi kapasitas maksimal (4)!");
        }
        else {
            for (int i = 0; i < setBan.length; i++) {
                this.ban[i] = setBan[i];
                System.out.println("Ban berhasil diSet!");
            }
        }
    }

    public void tampilkanSpesifikasi() {
        System.out.println("Merk Mobil : " + merkMobil);
        System.out.println("Warna Mobil : " + warna);
        System.out.println("Mesin Mobil : " + mesin.getNomorSeri());
        System.out.println("Kapasitas CC : " + mesin.getKapasitasCC());
        for (int i = 0; i < ban.length; i++) {
            System.out.println("Ban Mobil : " + ban[i] + "\n");   
        }
    }
}
