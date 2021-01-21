package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity

public class Ingrijitor implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;
    @Column(name = "nume")
    private String nume;
    @Column(name="parola")
    private String parola;
    @Column(name = "data_N")
    private String data_N;
    @Column(name = "sex")
    private String sex;
    @Column(name = "adresa")
    private String adr;

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public Ingrijitor() {
    }
    public Ingrijitor(String n,String d,String s,String a,String p){

        nume=n;
        data_N=d;
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
}
