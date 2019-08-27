package satella.app.posyanduku.models;

public class Anak {
    private String noKK;
    private String namaLengkap;
    private String namaPanggilan;
    private String tempatLahir;
    private String tglLahir;
    private String jenisKlm;
    private String statusLahir;
    private String beratBlahir;
    private String tinggiBlahir;


    public Anak() {

    }

    public Anak(String noKK, String namaLengkap, String namaPanggilan, String tempatLahir, String tglLahir, String jenisKlm, String statusLahir, String beratBlahir, String tinggiBlahir) {
        this.noKK = noKK;
        this.namaLengkap = namaLengkap;
        this.namaPanggilan = namaPanggilan;
        this.tempatLahir = tempatLahir;
        this.tglLahir = tglLahir;
        this.jenisKlm = jenisKlm;
        this.statusLahir = statusLahir;
        this.beratBlahir = beratBlahir;
        this.tinggiBlahir = tinggiBlahir;
    }

    public String getNoKK() {
        return noKK;
    }

    public void setNoKK(String noKK) {
        this.noKK = noKK;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNamaPanggilan() {
        return namaPanggilan;
    }

    public void setNamaPanggilan(String namaPanggilan) {
        this.namaPanggilan = namaPanggilan;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }


    public String getJenisKlm() {
        return jenisKlm;
    }

    public void setJenisKlm(String jenisKlm) {
        this.jenisKlm = jenisKlm;
    }

    public String getStatusLahir() {
        return statusLahir;
    }

    public void setStatusLahir(String statusLahir) {
        this.statusLahir = statusLahir;
    }

    public String getBeratBlahir() {
        return beratBlahir;
    }

    public void setBeratBlahir(String beratBlahir) {
        this.beratBlahir = beratBlahir;
    }

    public String getTinggiBlahir() {
        return tinggiBlahir;
    }

    public void setTinggiBlahir(String tinggiBlahir) {
        this.tinggiBlahir = tinggiBlahir;
    }

    @Override
    public String toString() {
        return " " + noKK +
                " " + namaLengkap +
                " " + namaPanggilan +
                " " + tempatLahir +
                " " + tglLahir +
                " " + jenisKlm +
                " " + statusLahir +
                " " + beratBlahir +
                " " + tinggiBlahir ;
    }
}
