public class BukuMutasi {
    private String histori;

    BukuMutasi() {
        this.histori = "Histori";
    }

    public void catatLog(String aktivitas, double nominal) {
        this.histori = "Aktivitas : " + aktivitas + ", Nominal : " + nominal;
    }

    public void cetak() {
        System.out.println(this.histori + "\n");
    }
}
