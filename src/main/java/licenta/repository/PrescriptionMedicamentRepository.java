package licenta.repository;

import licenta.entity.PrescriptionMedicament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionMedicamentRepository extends CrudRepository<PrescriptionMedicament, Long> {

    List<PrescriptionMedicament> findByPrescriptionId(Integer id);
}
