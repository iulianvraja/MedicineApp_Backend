package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
@Table(name = "IngtoPacient")
public class IngtoPacient {
    private Pacient p;
    private Ingrijitor i;
    private int id;

    public IngtoPacient() {
    }
    @Id
    @Column(name = "Ingtop_id")
    @GeneratedValue
    public int getId() {
        return id;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Pacient_id")
    public Pacient getP() {
        return p;
    }

    public void setP(Pacient p) {
        this.p = p;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Ingrijitor_id")
    public Ingrijitor getI() {
        return i;
    }

    public void setI(Ingrijitor i) {
        this.i = i;
    }

    public void setId(int id) {
        this.id = id;
    }






}
