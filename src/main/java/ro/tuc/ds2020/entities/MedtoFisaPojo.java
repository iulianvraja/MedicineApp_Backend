package ro.tuc.ds2020.entities;

public class MedtoFisaPojo {
    private int id;
    private String numeM;
    private String dozaj;
    private String effect;
    private String stare;
    private String perioadaTratament;
    private String interval;

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public MedtoFisaPojo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeM() {
        return numeM;
    }

    public void setNumeM(String numeM) {
        this.numeM = numeM;
    }

    public String getDozaj() {
        return dozaj;
    }

    public void setDozaj(String dozaj) {
        this.dozaj = dozaj;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getStare() {
        return stare;
    }

    public void setStare(String stare) {
        this.stare = stare;
    }

    public String getPerioadaTratament() {
        return perioadaTratament;
    }

    public void setPerioadaTratament(String perioadaTratament) {
        this.perioadaTratament = perioadaTratament;
    }
}
