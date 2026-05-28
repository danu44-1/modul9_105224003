public class RekeningPrioritas extends Rekening {
    
    RekeningPrioritas(String noRek, String namaP, double saldo, String pin) {
        super(noRek, namaP, saldo, pin);
    }

    @Override
    public void tarik(double biaya) {
        if (getSaldoRek() < 100000.0) {
            System.out.println("Batas minimum penarikan adalah 100000");
        }
        else {
            super.tarik(biaya);
            System.out.println("Saldo Rekening : " + getSaldoRek());
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
