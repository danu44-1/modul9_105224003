public class RuanganOp {
    protected String nomorRegistrasi;
    protected int kapasitasMaks;

    RuanganOp(String noReg, int kapasitasMaks) {
        this.nomorRegistrasi = noReg;
        this.kapasitasMaks = kapasitasMaks;
    }

    public String getNomorRegistrasi() {
        return nomorRegistrasi;
    }

    public int getKapasitasMaks() {
        return kapasitasMaks;
    }


}
