public class CustomerService {
    private String cs;

    CustomerService(String cs) {
        this.cs = cs;
    }
    public void layaniKeluhan(String namaNasabah, String keluhan) {
        System.out.println("CS " + cs + ", Menerima keluhan dari " + namaNasabah + ": '" + keluhan + "'");
        System.out.println("CS " + cs + ", Solusi: Keluhan Anda telah diproses oleh pusat dukungan NeoBank.");
    }
}
