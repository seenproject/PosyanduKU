package satella.app.posyanduku.posyandu.models;

public class timbangs {
    private String kodePosyandu;
    private String noKk;
    private String noNik;
    private String tanggalTimbang;
    private String tinggiBadan;
    private String beratBadan;
    private String lingkaranKepala;

    public timbangs(){

    }



    public timbangs(String kodePosyandu, String noKk, String noNik, String tanggalTimbang, String tinggiBadan, String beratBadan, String lingkaranKepala){
        this.kodePosyandu = kodePosyandu;
        this.noKk = noKk;
        this.noNik = noNik;
        this.tanggalTimbang = tanggalTimbang;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
        this.lingkaranKepala = lingkaranKepala;


    }

    public String getKodePosyandu() {
        return kodePosyandu;
    }

    public void setKodePosyandu(String kodePosyandu) {
        this.kodePosyandu = kodePosyandu;
    }

    public String getNoKk() {
        return noKk;
    }

    public void setNoKk(String noKk) {
        this.noKk = noKk;
    }

    public String getNoNik() {
        return noNik;
    }

    public void setNoNik(String noNik) {
        this.noNik = noNik;
    }

    public String getTanggalTimbang() {
        return tanggalTimbang;
    }

    public void setTanggalTimbang(String tanggalTimbang) {
        this.tanggalTimbang = tanggalTimbang;
    }

    public String getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(String tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public String getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(String beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getLingkaranKepala() {
        return lingkaranKepala;
    }

    public void setLingkaranKepala(String lingkaranKepala) {
        this.lingkaranKepala = lingkaranKepala;
    }


}