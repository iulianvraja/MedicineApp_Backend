package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.entities.Medtofisa;
import ro.tuc.ds2020.repositories.MedtofisaRepo;

import java.util.List;

@Service
public class MedtofisaService {

    private final MedtofisaRepo rep;

    @Autowired
    public MedtofisaService(MedtofisaRepo rep) {
        this.rep = rep;
    }

    public List<Medtofisa> findPersons() {
        List<Medtofisa> personList = rep.findAll();
        return personList;
    }

    public void insert(Medtofisa p) {
        rep.save(p);
    }
}
