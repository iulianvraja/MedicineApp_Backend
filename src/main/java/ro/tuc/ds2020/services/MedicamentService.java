package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.entities.Medicamente;
import ro.tuc.ds2020.entities.Pacient;
import ro.tuc.ds2020.repositories.MedicamentRepo;
import ro.tuc.ds2020.repositories.PacientRepo;

import java.util.List;

@Service
public class MedicamentService {


    private final MedicamentRepo rep;

    @Autowired
    public MedicamentService(MedicamentRepo rep) {
        this.rep = rep;
    }

    public List<Medicamente> findPersons() {
        List<Medicamente> personList = rep.findAll();
        return personList;
    }



    public void insert(Medicamente p) {
        rep.save(p);
    }
    public Medicamente getmedbyname(String name){

        return (Medicamente)rep.findByNameing(name);
    }
    public void delete(String name){

        Medicamente t= (Medicamente) rep.findByNameing(name);
        System.out.println("Merge delete: in medicamente");
        rep.delete(t);
    }
}
