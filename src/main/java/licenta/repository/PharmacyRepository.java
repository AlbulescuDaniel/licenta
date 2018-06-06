package licenta.repository;

import licenta.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    @Query(value = "select p from Pharmacy p where p.IDPharmacy = ?1 and p.city = ?2")
    Pharmacy findByIDPharmacyAndByCity(Integer IDPharmacy, String city);
}
