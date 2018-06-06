package licenta.repository;

import licenta.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    Patient findByEmailAndPassword(String email, String password);

    Patient findByEmail(String email);

    List<Patient> findAll();
}