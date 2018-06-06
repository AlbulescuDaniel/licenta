package licenta.repository;

import licenta.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findAll();

    @Query(value = "select p from Prescription p , Patient pa where pa.email = ?1 and pa.idPatient = p.idPatient and p.datePrescripted >= ?2 and p.datePrescripted <= ?3")
    List<Prescription> findByEmailBetweenDates(String email, Date fromDate, Date toDate);

    @Query(value = "select p from Prescription p , Patient pa where pa.cnp = ?1 and pa.idPatient = p.idPatient and p.datePrescripted >= ?2 and p.datePrescripted <= ?3")
    List<Prescription> findBycnpBetweenDates(String cnp, Date fromDate, Date toDate);

    @Query(value = "select p.prescriptionsByIdPatient from Patient p where p.email = ?1")
    List<Prescription> findByEmail(String email);
}