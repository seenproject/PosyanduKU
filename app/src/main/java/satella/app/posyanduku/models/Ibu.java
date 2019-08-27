package satella.app.posyanduku.models;

public class Ibu {
    private String nama_ibu;
    private String pekerjaan;
    private String pendidikan;
    private String alamat;
    private String agama;
    private String tempat_lahir;
    private String tanggal_lahir;

    public Ibu() {

    }

    public Ibu(String nama_ibu, String pekerjaan, String pendidikan, String alamat, String agama, String tempat_lahir, String tanggal_lahir) {
        this.nama_ibu = nama_ibu;
        this.pekerjaan = pekerjaan;
        this.pendidikan = pendidikan;
        this.alamat = alamat;
        this.agama = agama;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNama_ibu() {
        return nama_ibu;
    }

    public void setNama_ibu(String nama_ibu) {
        this.nama_ibu = nama_ibu;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    @Override
    public String toString() {
        return " " + nama_ibu +
                " " + pekerjaan +
                " " + pendidikan +
                " " + alamat +
                " " + agama +
                " " + tempat_lahir +
                " " + tanggal_lahir ;
    }
}
