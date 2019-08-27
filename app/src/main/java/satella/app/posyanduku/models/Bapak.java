package satella.app.posyanduku.models;

public class Bapak {
    private String noKkBapak;
    private String nama_bapak;
    private String pekerjaan;
    private String pendidikan;
    private String alamat;
    private String agama;
    private String tempat_lahir;
    private String tanggal_lahir;

    public Bapak() {

    }

    public Bapak(String noKkBapak, String nama_bapak, String pekerjaan, String pendidikan, String alamat, String agama, String tempat_lahir, String tanggal_lahir) {
        this.noKkBapak = noKkBapak;
        this.nama_bapak = nama_bapak;
        this.pekerjaan = pekerjaan;
        this.pendidikan = pendidikan;
        this.alamat = alamat;
        this.agama = agama;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNoKkBapak() {
        return noKkBapak;
    }

    public void setNoKkBapak(String noKkBapak) {
        this.noKkBapak = noKkBapak;
    }

    public String getNama_bapak() {
        return nama_bapak;
    }

    public void setNama_bapak(String nama_bapak) {
        this.nama_bapak = nama_bapak;
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
        return " " + noKkBapak +
                " " + nama_bapak +
                " " + pekerjaan +
                " " + pendidikan +
                " " + alamat +
                " " + agama +
                " " + tempat_lahir +
                " " + tanggal_lahir;
    }
}
