package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.entities.*;
import ro.tuc.ds2020.services.MedicamentService;
import ro.tuc.ds2020.services.MedtofisaService;
import ro.tuc.ds2020.services.PacientService;
import ro.tuc.ds2020.services.PersonService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/pacient")
public class PersonController {

    private final PacientService personService;
    private final MedicamentService mersserv;
    private final MedtofisaService serv;

    @Autowired
    public PersonController(PacientService personService, MedicamentService m,MedtofisaService serv) {
        this.serv=serv;
        this.personService = personService;
        this.mersserv=m;
    }

    @GetMapping()
    public ResponseEntity<List<AddPacientForm>> getPersons() {
        List<Pacient> dtos = personService.findPersons();

        List<AddPacientForm> ls=new ArrayList<>();
        for(Pacient i:dtos){
            AddPacientForm p=new AddPacientForm();
            p.setAdr(i.getAdr());
            p.setData_n(i.getData_n());
            p.setNume(i.getNume());
            p.setParola(i.getParola());
            p.setPerioadaTratament(i.getFis().getPerioadaTratament());
            p.setStare(i.getFis().getStare());
            p.setId(i.getId());
            p.setSex(i.getSex());
            ls.add(p);

        }

        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<List<Pacient>> insertProsumer(@Valid @RequestBody AddPacientForm fp) {
        System.out.println(fp.getData_n()+" "+fp.getPerioadaTratament()+" "+fp.getStare());
        Pacient p=new Pacient(fp.getNume(),fp.getParola(),fp.getData_n(),fp.getSex(),fp.getAdr());
        FisaMedicala fm=new FisaMedicala();
        fm.setPerioadaTratament(fp.getPerioadaTratament());
        fm.setStare(fp.getStare());
        p.setFis(fm);
        personService.insert(p);
        List<Pacient> dtos = personService.findPersons();
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }
    @DeleteMapping (value="/{name}")
    public ResponseEntity<List<Pacient>> deletep(@PathVariable("name") String nume){
        System.out.println("Am facut delete"+nume);

        personService.delete(nume);

        return ResponseEntity.ok().build();
    }
    //update
    @PutMapping()
    public ResponseEntity<List<Pacient>> update(@Valid @RequestBody UpdatePacientForm i){
        System.out.println("Facem update la persoana");
        personService.delete(i.getNumeup());
        Pacient ig=new Pacient();
        ig.setAdr(i.getAdr());
        ig.setData_n(i.getData_N());
        ig.setNume(i.getNume());
        ig.setParola(i.getParola());
        ig.setSex(i.getSex());
        FisaMedicala fis=new FisaMedicala();
        fis.setStare(i.getStare());
        fis.setPerioadaTratament(i.getPerioadaTratament());
        ig.setFis(fis);
        System.out.println("am intrat in update"+i.getAdr()+i.getData_N()+i.getNume()+i.getNumeup());
        personService.insert(ig);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="/{createmed}")
    public ResponseEntity createmed(@Valid @RequestBody AddMedicationForm i){
        System.out.println("facem adaugarea medication"+i.getNumem()+i.getInterval());
        Pacient p=personService.getpacientbyname(i.getNumep());
        FisaMedicala f=p.getFis();
        Medicamente m= mersserv.getmedbyname(i.getNumem());
        Medtofisa mf=new Medtofisa();
        mf.setM(m);
        mf.setF(f);
        mf.setInterval(i.getInterval());
        serv.insert(mf);
        return ResponseEntity.ok().build();
    }





}
