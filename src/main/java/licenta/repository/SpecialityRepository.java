package licenta.repository;

import licenta.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

    Speciality findByIdSpeciality(Integer id);

    List<Speciality> findAll();

}
