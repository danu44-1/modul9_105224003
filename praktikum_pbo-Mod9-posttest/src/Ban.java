public class Ban {
    protected String merk;
    protected int ukuranRing;

    public Ban(String merk, int ukuranRing) {
        this.merk = merk;
        this.ukuranRing = ukuranRing;
    }

    public void gudang() {
        System.out.println("\nMerk Ban : " + this.merk);
        System.out.println("Ukuran Ring : " + this.ukuranRing);
    }

}
