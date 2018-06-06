package licenta.repository;

import licenta.entity.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

    Medicament findByIdMedicament(Integer id);

    Medicament findByName(String name);
}
