public abstract class Rekening implements Otorisasi{
    private String nomorRekening;
    private String namaPemilik;
    private double saldoRek;
    private String pin;
    private final BukuMutasi mutasi; // komposisi

    Rekening(String noRek, String namaP, double saldo, String pin) {
        this.nomorRekening = noRek;
        this.namaPemilik = namaP;
        this.saldoRek = saldo;
        this.pin = pin;
        this.mutasi = new BukuMutasi(); // hubungan komposisi yang ketika si rekening dibuat, buku mutasi juga pasti kebuat dan bergantung dengan rekening ini
        this.mutasi.catatLog("Rekening awal", saldo); 
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public String getPin() {
        return pin;
    }

    public double getSaldoRek() {
        return saldoRek;
    }

    public BukuMutasi getMutasi() {
        return mutasi;
    }


    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public void setSaldoRek(double saldoRek) {
        this.saldoRek = saldoRek;
    }
    
    
    public void tarik(double biaya) {
        setSaldoRek(saldoRek - biaya);
        this.mutasi.catatLog("Penarikan", biaya);
    }

    public void setor(double biaya) {
        setSaldoRek(saldoRek + biaya);
        this.mutasi.catatLog("Setor", biaya);
    }

    @Override
    public boolean verifikasiPIN(String pin) {
        if (this.pin == pin) {
            return true;
        }
        else {
            System.out.println("Error");
            return false;
        }
    }


}
