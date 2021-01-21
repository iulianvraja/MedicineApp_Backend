package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.tuc.ds2020.entities.Medicamente;


import java.util.UUID;

public interface MedicamentRepo extends JpaRepository<Medicamente,Integer> {
    @Query(value = "SELECT p " +
            "FROM Medicamente p " +
            "WHERE p.nume = :nume "
    )
    Medicamente findByNameing(String nume);


}
