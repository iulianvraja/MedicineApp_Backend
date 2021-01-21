package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.tuc.ds2020.MedicationPlan;
import ro.tuc.ds2020.entities.Pacient;

public interface MedicationPlanRepo extends JpaRepository<MedicationPlan,Integer> {
    @Query(value = "SELECT p " +
            "FROM MedicationPlan p " +
            "WHERE p.ziua = :ziua "
    )
    MedicationPlan findByday(String ziua);
}
