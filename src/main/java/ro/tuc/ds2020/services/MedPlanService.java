package ro.tuc.ds2020.services;

import org.springframework.stereotype.Service;
import ro.tuc.ds2020.MedicationPlan;
import ro.tuc.ds2020.repositories.MedicationPlanRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedPlanService {

    private final MedicationPlanRepo rep;

    public MedPlanService(MedicationPlanRepo rep) {
        this.rep = rep;
    }


    public List<MedicationPlan> findMedsPlans(String day) {
        List<MedicationPlan> medlist = rep.findAll();

        List<MedicationPlan> flist=new ArrayList<MedicationPlan>();
        for(MedicationPlan ii:medlist){
            if(ii.getZiua().equals(day))
                flist.add(ii);
        }

        return flist;
    }


    public void insert(MedicationPlan p) {
        rep.save(p);
    }
}
