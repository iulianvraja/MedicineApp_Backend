package ro.tuc.ds2020.entities;

public class UpdateForm {

    private String nume;
   private String  parola;
    private String data_N;
    private String adr;
    private String sex;
    private String numeup;

    public UpdateForm() {
    }

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
}
