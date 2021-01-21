package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.entities.AddPacientForm;
import ro.tuc.ds2020.entities.Medicamente;
import ro.tuc.ds2020.entities.UpdateMedicamentForm;
import ro.tuc.ds2020.services.MedicamentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/medicamente")
public class MedicamentControlller {


    private final MedicamentService personService;


    @Autowired
    public MedicamentControlller(MedicamentService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public ResponseEntity<List<Medicamente>> getPersons() {
        List<Medicamente> dtos = personService.findPersons();



        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<List<Medicamente>> insertProsumer(@Valid @RequestBody Medicamente fp) {

        personService.insert(fp);
        List<Medicamente> dtos = personService.findPersons();
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }
    @DeleteMapping (value="/{name}")
    public ResponseEntity<List<Medicamente>> deletep(@PathVariable("name") String nume){
        System.out.println("Am facut delete"+nume);

        personService.delete(nume);

        return ResponseEntity.ok().build();
    }

    @PutMapping()
   public ResponseEntity<List<Medicamente>> update(@Valid @RequestBody UpdateMedicamentForm i){
        System.out.println("Facem update la persoana");
        personService.delete(i.getNumeup());
        Medicamente p=new Medicamente();
        p.setNume(i.getNume());
        p.setDozaj(i.getDozaj());
        p.setEffect(i.getEffect());
        System.out.println("am intrat in update"+i.getNume()+i.getNumeup());
        personService.insert(p);

        return ResponseEntity.ok().build();
    }

}
