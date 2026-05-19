public class Mesin {
    protected String nomorSeri;
    protected int kapasitasCC;

    Mesin(String nomorSeri, int kapasitasCC) {
        this.nomorSeri = nomorSeri;
        this.kapasitasCC = kapasitasCC;
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public int getKapasitasCC() {
        return kapasitasCC;
    }
}
