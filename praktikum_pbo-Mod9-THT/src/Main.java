import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        CustomerService cs = new CustomerService("NeoCS");
        Rekening bank = null;
        Nasabah profilNasabah = null;
        int pilihan;

        do {
            System.out.println("\nMENU UTAMA:");
            System.out.println("1. Registrasi Profil Nasabah");
            System.out.println("2. Buka Rekening Baru (Reguler/Prioritas)");
            System.out.println("3. Simulasi Transaksi & Lihat Mutasi (Login)");
            System.out.println("4. Hubungi Customer Service (Asosiasi)");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            pilihan = in.nextInt();
            in.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama : ");
                    String nama = in.nextLine();
                    profilNasabah = new Nasabah(nama);
                    System.out.println("Profil nasabah atas nama '" + nama + "' berhasil dibuat!");
                    break;

                case 2:
                    if (profilNasabah == null) {
                        System.out.println("Error: Silakan registrasi nasabah terlebih dahulu.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Baru: ");
                    String noRek = in.nextLine();

                    System.out.print("Setoran Awal: Rp");
                    double saldo = in.nextDouble();

                    System.out.print("Buat PIN : ");
                    in.nextLine();
                    String pin = in.nextLine();

                    System.out.println("1. Reguler (Potongan Admin Rp2.5rb)");
                    System.out.println("2. Prioritas (Batas Min Tarik Rp100rb)");
                    System.out.print("Pilih Jenis Rekening: ");
                    int jenis = in.nextInt();

                    if (jenis == 1) {
                        bank = new RekeningReguler(noRek, profilNasabah.getNama(), saldo, pin);
                    } 
                    else {
                        bank = new RekeningPrioritas(noRek, profilNasabah.getNama(), saldo, pin);
                    }

                    profilNasabah.tambahRekening(bank);
                    break;

                case 3:
                    if (bank == null) {
                        System.out.println("Error: Belum ada rekening aktif di sistem.");
                        break;
                    }
                    System.out.print("Masukkan PIN Akun Anda: ");
                    String pinIn = in.nextLine();
                    
                    bank.verifikasiPIN(pinIn);
                    
                    if (bank.verifikasiPIN(pinIn) == false) {
                        System.out.println("!!");
                    }
                    else {
                        System.out.println("1. Penarikan Tunai");
                        System.out.println("2. Setor Tunai");
                        System.out.println("3. Cetak Histori Buku Mutasi");
                        System.out.print("Pilih : ");
                        int pilih = in.nextInt();
                        
                        if (pilih == 1) {
                            System.out.print("Penarikan : Rp");
                            double tarikRp = in.nextDouble();
                            bank.tarik(tarikRp);
                        }
                        else if (pilih == 2) {
                            System.out.print("Setoran : Rp");
                            double setorRp = in.nextDouble();
                            bank.setor(setorRp);
                        } 
                        else if (pilih == 3) {
                            bank.getMutasi().cetak();;
                        }
                    }

                    break;

                case 4:
                    if (profilNasabah == null) {
                        System.out.println("Error: Silakan registrasi nasabah terlebih dahulu.");
                        break;
                    }
                    System.out.print("Tuliskan keluhan Anda kepada CS: ");
                    String keluhan = in.nextLine();
                    profilNasabah.hubungiCS(cs, keluhan);
                    break;

                case 5:
                    in.close();
                    break;
            
                default:
                    System.out.println("Pilhan tidak valid");
                    break;
            }
        } while (pilihan != 5);

        profilNasabah = null; // akun nasabah dibuat jadi null 
        System.out.println("Nama : " + bank.getNamaPemilik()); // rekening masih dapat dipanggil independen
        System.out.println("Saldo : " + bank.getSaldoRek());
        // Pembuktian ketika akun nasabah (objek profilNasabah) ditutup atau dibuat (profilNasabah = null), rekening (objek Rekening) masih dapat dipanggil dan tidak ikut hancur karena entitas rekening independen dan hanya menjadi bagian dari menjadi nasabah. Membuktikan hubungan Aggregasi antara entitas Nasabah dengan entitas Rekening.
        // Yang dalam siklus hidupnya, entitas Nasabah dapat menampung objek Rekening dan hanya menyimpannya (method tambahRekening(Rekening rek)), namun objek Rekening juga bisa hidup secara independen.

        bank = null; // objek Rekening ditutup
        bank.getMutasi().cetak();; // seluruh data rekening juga terhapus temasuk objek buku mutasi
        // Pembuktian ketika rekening yang ditutup (objek rekening null), entitas BukuMutasi yang menjadi objek ketika pembuatan rekening jadi tidak dapat diakses. Dikarenakan entitas BukuMutasi bergantung pada objek dari Rekening. Membuktikan hubungan Komposisi antara entitas BukuMutasi dengan entitas Rekening.
        // Yang siklus hidup objek BukuMutasi bergantung saat diinstansiasi di dalam constructornya Objek Rekening (Pemilik).
    }
}
