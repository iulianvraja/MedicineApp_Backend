package ro.tuc.ds2020.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public class SensorData {


    private String activity;

    private String patient_id;

    private String start;

    private String end;
    public SensorData(){}
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
