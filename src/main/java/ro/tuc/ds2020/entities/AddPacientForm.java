package ro.tuc.ds2020.entities;


import org.springframework.hateoas.RepresentationModel;
import ro.tuc.ds2020.dtos.IngrijitorDTO;

import java.util.Objects;

public class AddPacientForm extends RepresentationModel<AddPacientForm>{
    private int id;
    private String stare;

    private String perioadaTratament;

    private String nume;

    private String parola;

    private String data_n;

    private String sex;

    private String adr;


    public AddPacientForm(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getData_n() {
        return data_n;
    }

    public void setData_n(String data_n) {
        this.data_n = data_n;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddPacientForm that = (AddPacientForm) o;
        return  id==that.id &&
                Objects.equals(nume, that.nume) &&
                Objects.equals(data_n, that.data_n)&&
                Objects.equals(sex, that.sex) &&
                Objects.equals(adr, that.adr) &&
                Objects.equals(parola, that.parola) &&
                Objects.equals(stare, that.stare) &&
                Objects.equals(perioadaTratament, that.perioadaTratament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nume, data_n, sex,adr,parola,stare,perioadaTratament);
    }
}
