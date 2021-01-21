package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
@Table(name = "Medic")
public class MedicPojo {

    private int id;
    @Column(name = "nume",nullable = false)
    private String nume;
    @Column(name = "parola",nullable = false)
    private String parola;
    public MedicPojo(){

    }

    public MedicPojo(int id, String nume, String parola) {
        this.id = id;
        this.nume = nume;
        this.parola = parola;
    }

    @Id
    @Column(name = "Medic_id")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
