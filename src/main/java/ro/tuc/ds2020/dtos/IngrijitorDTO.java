package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;
import ro.tuc.ds2020.entities.Ingrijitor;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class IngrijitorDTO extends RepresentationModel<PersonDTO> {
    private UUID id;

    private String nume;

    private String data_N;

    private String sex;

    private String adr;

    private String parola;

    public IngrijitorDTO(){}
    public IngrijitorDTO(UUID id, String nume,String d, String s,String a,String p){
        this.id=id;
        this.nume=nume;
        this.data_N=d;
        sex=s;
        adr=a;
        parola=p;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getData_N() {
        return data_N;
    }

    public void setData_N(String data_N) {
        this.data_N = data_N;
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

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngrijitorDTO that = (IngrijitorDTO) o;
        return Objects.equals(nume, that.nume) &&
                Objects.equals(data_N, that.data_N)&&
                Objects.equals(sex, that.adr) &&
                Objects.equals(parola, that.parola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, data_N, sex,adr,parola);
    }
}
