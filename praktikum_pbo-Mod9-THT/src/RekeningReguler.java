public class RekeningReguler extends Rekening {

    RekeningReguler(String noRek, String namaP, double saldo, String pin) {
        super(noRek, namaP, saldo, pin);
    }

    @Override
    public void tarik(double biaya) {
        if (getSaldoRek() >= biaya + 2500.0) {
            super.tarik(biaya + 2500.0);
        }
        else {
            System.out.println("Saldo tidak mencukupi");
        }
    }
    
    @Override
    public void setor(double biaya) {
        super.setor(biaya);
    }

    @Override
    public boolean verifikasiPIN(String pin) {
        if (pin.equals(getPin())) {
           System.out.println("Login Berhasil! Saldo : Rp" + getSaldoRek());
           return true;
        }
        else {
            System.out.println("Error");
            return false;
        }
    }

}