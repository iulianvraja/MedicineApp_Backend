package ro.tuc.ds2020.entities;

public class UpdatePacientForm {

    private String nume;
    private String  parola;
    private String data_N;
    private String adr;
    private String sex;
    private String perioadaTratament;
    private String stare;
    private String numeup;


    public UpdatePacientForm(){}


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getData_N() {
        return data_N;
    }

    public void setData_N(String data_N) {
        this.data_N = data_N;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNumeup() {
        return numeup;
    }

    public void setNumeup(String numeup) {
        this.numeup = numeup;
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
