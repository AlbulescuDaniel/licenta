package licenta.repository;

import licenta.entity.PharmacyStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyStockRepository extends JpaRepository<PharmacyStock, Long> {

    List<PharmacyStock> findByMedicamentId(Integer id);

}
