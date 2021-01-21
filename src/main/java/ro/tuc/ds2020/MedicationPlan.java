package ro.tuc.ds2020;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MedicationPlan")
public class MedicationPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    @Column(name="interval_orar")
    private String interval_orar;
    @Column(name="nume_medicament")
    private String nume_medicamentt;
    @Column(name="idpers")
    private int idpers;
    @Column(name="ziua")
    private String ziua;

    public MedicationPlan(String interval, String nume_medicamentt, int idpers,String ziua) {
        this.ziua=ziua;
        this.interval_orar = interval;
        this.nume_medicamentt = nume_medicamentt;
        this.idpers = idpers;
    }

    public MedicationPlan() {
    }

    public String getZiua() {
        return ziua;
    }

    public void setZiua(String ziua) {
        this.ziua = ziua;
    }

    @Id
    @Column(name = "Medication_PlanID")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterval_orar() {
        return interval_orar;
    }

    public void setInterval_orar(String interval_orar) {
        this.interval_orar = interval_orar;
    }

    public String getNume_medicamentt() {
        return nume_medicamentt;
    }

    public void setNume_medicamentt(String nume_medicamentt) {
        this.nume_medicamentt = nume_medicamentt;
    }

    public int getIdpers() {
        return idpers;
    }

    public void setIdpers(int idpers) {
        this.idpers = idpers;
    }
}
