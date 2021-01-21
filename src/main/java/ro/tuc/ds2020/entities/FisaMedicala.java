package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
@Table(name = "Fisamedicala")
public class FisaMedicala {

    private int id;
    @Column(name = "stare")
    private String stare;
    @Column(name = "perioadatratament")
    private String perioadaTratament;

    public FisaMedicala(){}

    @Id
    @Column(name = "Fisa_id")
    @GeneratedValue
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
}
