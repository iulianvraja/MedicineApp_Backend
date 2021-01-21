package ro.tuc.ds2020.controllers;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.IngrijitorDTO;
import ro.tuc.ds2020.dtos.IngrijitorDetailsDTO;
import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.entities.Ingrijitor;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.entities.UpdateForm;
import ro.tuc.ds2020.services.IngrijitorService;
import ro.tuc.ds2020.services.PersonService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/ingrijitor")
public class IngrijitorController {

    private final IngrijitorService personService;

    @Autowired
    public IngrijitorController(IngrijitorService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public ResponseEntity<List<IngrijitorDTO>> getPersons() {
        List<IngrijitorDTO> dtos = personService.findPersons();
        for (IngrijitorDTO dto : dtos) {
            Link IngrijitorLink = linkTo(methodOn(IngrijitorController.class)
                    .getIngrijitor(dto.getId())).withRel("personDetails");
            dto.add(IngrijitorLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody IngrijitorDetailsDTO ingDTO) {
        UUID personID = personService.insert(ingDTO);
        return new ResponseEntity<>(personID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IngrijitorDetailsDTO> getIngrijitor(@PathVariable("id") UUID personId) {
        IngrijitorDetailsDTO dto = personService.findPersonById(personId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

@DeleteMapping (value="/{name}")
    public ResponseEntity<List<IngrijitorDTO>> deleteing(@PathVariable("name") String nume){
        System.out.println("Am facut delete"+nume);

        personService.delete(nume);

        return ResponseEntity.ok().build();
    }
    @PutMapping()
    public ResponseEntity<List<IngrijitorDTO>> update(@Valid @RequestBody UpdateForm i){
        System.out.println("suntem in update ingrijitor" );
        personService.delete(i.getNumeup());
        IngrijitorDetailsDTO ig=new IngrijitorDetailsDTO();
        ig.setAdr(i.getAdr());
        ig.setData_N(i.getData_N());
        ig.setNume(i.getNume());
        ig.setParola(i.getParola());
        ig.setSex(i.getSex());
        System.out.println("am intrat in update"+i.getAdr()+i.getData_N()+i.getNume()+i.getNumeup());
        personService.insert(ig);
        List<IngrijitorDTO> dtos = personService.findPersons();
        for (IngrijitorDTO dto : dtos) {
            Link IngrijitorLink = linkTo(methodOn(IngrijitorController.class)
                    .getIngrijitor(dto.getId())).withRel("personDetails");
            dto.add(IngrijitorLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


}
