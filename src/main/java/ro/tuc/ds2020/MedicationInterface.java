package ro.tuc.ds2020;

import java.util.ArrayList;

public interface MedicationInterface {
    ArrayList<MedicationPlan> medplanRide(String pickUpLocation) throws Exception;
}
