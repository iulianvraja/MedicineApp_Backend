package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.IngrijitorDTO;
import ro.tuc.ds2020.dtos.IngrijitorDetailsDTO;
import ro.tuc.ds2020.entities.Ingrijitor;

public class IngrijitorBuilder {

    public IngrijitorBuilder() {
    }

    public static IngrijitorDTO toIngrijitorDTO(Ingrijitor person) {
        return new IngrijitorDTO(person.getId(), person.getNume(), person.getData_N(),person.getSex(),person.getAdr(),person.getParola());
    }

    public static IngrijitorDetailsDTO toIngrijitorDetailsDTO(Ingrijitor person) {
        return new IngrijitorDetailsDTO(person.getId(), person.getNume(), person.getData_N(),person.getSex(),person.getAdr(),person.getParola());
    }

    public static Ingrijitor toEntity(IngrijitorDetailsDTO personDetailsDTO) {
        return new Ingrijitor(
                personDetailsDTO.getNume(),
                personDetailsDTO.getData_N(),
                personDetailsDTO.getSex(),
                personDetailsDTO.getAdr(),
                personDetailsDTO.getParola());
    }
}
