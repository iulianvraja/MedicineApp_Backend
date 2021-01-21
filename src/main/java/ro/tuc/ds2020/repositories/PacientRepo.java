package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.tuc.ds2020.entities.Ingrijitor;
import ro.tuc.ds2020.entities.Pacient;

public interface PacientRepo extends JpaRepository<Pacient,Integer> {
    @Query(value = "SELECT p " +
            "FROM Pacient p " +
            "WHERE p.nume = :nume "
    )
    Pacient findByNameing(String nume);
}
