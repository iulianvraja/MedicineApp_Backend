package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.IngrijitorDTO;
import ro.tuc.ds2020.dtos.builders.IngrijitorBuilder;
import ro.tuc.ds2020.entities.Pacient;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.repositories.PacientRepo;
import ro.tuc.ds2020.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PacientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngrijitorService.class);
    private final PacientRepo rep;

    @Autowired
    public PacientService(PacientRepo rep) {
        this.rep = rep;
    }

    public List<Pacient> findPersons() {
        List<Pacient> personList = rep.findAll();
        return personList;
    }



    public void insert(Pacient p) {
        rep.save(p);
    }

    public Pacient getpacientbyname(String name){

        return (Pacient)rep.findByNameing(name);
    }
    public void delete(String name){

        Pacient t= (Pacient)rep.findByNameing(name);
        System.out.println("Merge delete:");
        rep.delete(t);
    }
}
