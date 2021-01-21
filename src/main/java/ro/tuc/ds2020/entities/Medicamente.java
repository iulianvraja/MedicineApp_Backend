package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
@Table(name = "Medicamente")
public class Medicamente {
    private int id;
    @Column(name="nume")
    private String nume;
    @Column(name="effect")
    private String effect;
    @Column(name="dozaj")
    private String dozaj;

    public Medicamente() {
    }
    @Id
    @Column(name = "Med_id")
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
}
