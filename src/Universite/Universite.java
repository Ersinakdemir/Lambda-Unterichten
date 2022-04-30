package Universite;

public class Universite {
    /*TASK :
    fields --> Universite (String)
    bolum (String)
    ogrcSayisi (int)
    notOrt (int)
    olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.
            */
    private String unuversite;
    private String bolum;
    private int ogrSayisi;
    private double notOrt;

    public Universite() {

    }

    public Universite(String unuversite, String bolum, int ogrSayisi, double notOrt) {
        this.unuversite = unuversite;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrt = notOrt;
    }

    public String getUnuversite() {
        return unuversite;
    }

    public void setUnuversite(String unuversite) {
        this.unuversite = unuversite;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public double getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(double notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "unuversite='" + unuversite + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrt=" + notOrt +
                "\n"+'}';
    }
}
