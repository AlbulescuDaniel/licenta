package licenta.repository;

import licenta.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findByEmailAndPassword(String email, String password);

    Doctor findByEmail(String email);

    List<Doctor> findAll();
}
