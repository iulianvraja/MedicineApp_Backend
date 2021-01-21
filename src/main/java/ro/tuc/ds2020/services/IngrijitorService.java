package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.IngrijitorDTO;
import ro.tuc.ds2020.dtos.IngrijitorDetailsDTO;
import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.dtos.builders.IngrijitorBuilder;
import ro.tuc.ds2020.dtos.builders.PersonBuilder;
import ro.tuc.ds2020.entities.Ingrijitor;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.repositories.IngrijitorRepository;
import ro.tuc.ds2020.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IngrijitorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(IngrijitorService.class);
    private final IngrijitorRepository rep;

    @Autowired
    public IngrijitorService(IngrijitorRepository rep) {
        this.rep = rep;
    }

    public List<IngrijitorDTO> findPersons() {
        List<Ingrijitor> personList = rep.findAll();
        return personList.stream()
                .map(IngrijitorBuilder::toIngrijitorDTO)
                .collect(Collectors.toList());
    }

    public IngrijitorDetailsDTO findPersonById(UUID id) {
        Optional<Ingrijitor> prosumerOptional = rep.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Person with id {} was not found in db", id);
            throw new ResourceNotFoundException(Person.class.getSimpleName() + " with id: " + id);
        }
        return IngrijitorBuilder.toIngrijitorDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(IngrijitorDetailsDTO personDTO) {
        Ingrijitor person = IngrijitorBuilder.toEntity(personDTO);
        person = rep.save(person);
        LOGGER.debug("Person with id {} was inserted in db", person.getId());
        return person.getId();
    }

    public void delete(String name){

       Ingrijitor t= (Ingrijitor)rep.findByNameing(name);
       System.out.println("Merge delete:"+t.getAdr()+t.getNume());
       rep.delete(t);
    }

}
