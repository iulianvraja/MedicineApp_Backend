package ro.tuc.ds2020;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ro.tuc.ds2020.controllers.IndexController;
import ro.tuc.ds2020.entities.FisaMedicala;
import ro.tuc.ds2020.entities.Medtofisa;
import ro.tuc.ds2020.repositories.MedicationPlanRepo;
import ro.tuc.ds2020.repositories.MedtofisaRepo;
import ro.tuc.ds2020.services.MedPlanService;
import ro.tuc.ds2020.services.MedicamentService;
import ro.tuc.ds2020.services.MedtofisaService;
import ro.tuc.ds2020.services.PacientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedPlanServiceImpl implements MedicationInterface {


private final MedPlanService serv;

    public MedPlanServiceImpl(MedPlanService s) {
        serv=s;
    }

    @Override
    public ArrayList<MedicationPlan> medplanRide(String mesage) throws Exception {
        System.out.println(mesage);
        ArrayList<MedicationPlan> arrfinal=get_med_plans(mesage);
        return arrfinal;
    }

    private ArrayList<MedicationPlan> get_med_plans(String mesage){
        List<MedicationPlan> arr=(List<MedicationPlan>)serv.findMedsPlans(mesage);
       ArrayList<MedicationPlan> arrfinal=new ArrayList<MedicationPlan>();
        for(MedicationPlan i:arr){
            if(i.getIdpers()==1)
                arrfinal.add(i);
        }
    return arrfinal;
    }
}
