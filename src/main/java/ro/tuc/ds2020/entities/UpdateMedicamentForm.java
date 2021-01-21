package ro.tuc.ds2020.entities;

public class UpdateMedicamentForm {
    private String nume;
    private String effect;
    private String dozaj;
    private String numeup;

    public UpdateMedicamentForm(){}
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getDozaj() {
        return dozaj;
    }

    public void setDozaj(String dozaj) {
        this.dozaj = dozaj;
    }

    public String getNumeup() {
        return numeup;
    }

    public void setNumeup(String numeup) {
        this.numeup = numeup;
    }
}
